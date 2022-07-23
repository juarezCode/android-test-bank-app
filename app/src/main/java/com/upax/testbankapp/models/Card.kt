package com.upax.testbankapp.models

import com.google.gson.annotations.SerializedName

data class CardResponse(
    val tarjetas: List<Card>
)

data class Card(
    val id: Int,
    @SerializedName("tarjeta")
    val card: String,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("saldo")
    val balance: Int,
    @SerializedName("estado")
    val status: String,
    @SerializedName("tipo")
    val type: String,
)

data class NewCard(
    val number: Int,
    val account: String,
    val issure: String,
    val name: String,
    val brand: String,
    val status: String,
    val balance: Int,
    val type: String
)