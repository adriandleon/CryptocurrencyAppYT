package com.adriandeleon.cryptocurrency.data.repository

import com.adriandeleon.cryptocurrency.data.remote.CoinPaprikaAPI
import com.adriandeleon.cryptocurrency.data.remote.dto.CoinDetailDTO
import com.adriandeleon.cryptocurrency.data.remote.dto.CoinListDTO
import com.adriandeleon.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
): CoinRepository {

    override suspend fun getCoins(): List<CoinListDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return api.getCoinById(id)
    }
}