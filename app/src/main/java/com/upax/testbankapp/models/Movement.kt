package com.upax.testbankapp.models

import com.google.gson.annotations.SerializedName

data class MovementResponse(
    val movimientos: List<Movement>
)

data class Movement(
    val id: Int,
    @SerializedName("fecha")
    val date: String,
    @SerializedName("descripcion")
    val description: String,
    @SerializedName("monto")
    val amount: String,
    @SerializedName("tipo")
    val type: String,
)
