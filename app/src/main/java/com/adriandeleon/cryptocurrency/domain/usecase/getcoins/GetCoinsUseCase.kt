package com.adriandeleon.cryptocurrency.domain.usecase.getcoins

import com.adriandeleon.cryptocurrency.common.Resource
import com.adriandeleon.cryptocurrency.domain.model.Coin
import com.adriandeleon.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (exception: HttpException) {
            emit(Resource.Error<List<Coin>>(exception.localizedMessage ?: "Unexpected error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}