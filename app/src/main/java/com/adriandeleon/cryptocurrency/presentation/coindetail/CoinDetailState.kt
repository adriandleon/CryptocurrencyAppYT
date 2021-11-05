package com.adriandeleon.cryptocurrency.presentation.coindetail

import com.adriandeleon.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)