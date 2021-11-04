package com.adriandeleon.cryptocurrency.domain.repository

import com.adriandeleon.cryptocurrency.data.remote.dto.CoinDetailDTO
import com.adriandeleon.cryptocurrency.data.remote.dto.CoinListDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinListDTO>
    suspend fun getCoinById(id: String): CoinDetailDTO
}