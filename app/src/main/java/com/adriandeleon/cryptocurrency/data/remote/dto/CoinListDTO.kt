package com.adriandeleon.cryptocurrency.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.adriandeleon.cryptocurrency.domain.model.Coin

data class CoinListDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) {

    fun toCoin(): Coin = Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
