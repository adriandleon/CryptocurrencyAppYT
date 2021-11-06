package com.adriandeleon.cryptocurrency.domain.usecase.getcoin

import com.adriandeleon.cryptocurrency.common.Resource
import com.adriandeleon.cryptocurrency.domain.model.CoinDetail
import com.adriandeleon.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (exception: HttpException) {
            emit(Resource.Error<CoinDetail>(exception.localizedMessage ?: "Unexpected error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}