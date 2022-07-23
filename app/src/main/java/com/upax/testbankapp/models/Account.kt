package com.upax.testbankapp.models

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    val cuenta: List<Account>
)

data class Account(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cuenta")
    val account: Long,
    @SerializedName("nombre")
    val name: String,
    @SerializedName("ultimaSesion")
    val lastSession: String
)