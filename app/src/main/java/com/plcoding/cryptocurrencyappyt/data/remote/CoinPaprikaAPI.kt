package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO
}