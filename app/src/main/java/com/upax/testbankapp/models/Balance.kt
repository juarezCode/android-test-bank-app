package com.upax.testbankapp.models

import com.google.gson.annotations.SerializedName

data class BalanceResponse(
    val saldos: List<Balance>
)

data class Balance(
    val id: Int,
    @SerializedName("cuenta")
    val account: String,
    @SerializedName("saldoGeneral")
    val amount: Int,
    @SerializedName("ingresos")
    val earnings: Int
)