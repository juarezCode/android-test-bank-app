package com.upax.testbankapp.api

import com.upax.testbankapp.models.AccountResponse
import com.upax.testbankapp.models.BalanceResponse
import com.upax.testbankapp.models.CardResponse
import com.upax.testbankapp.models.MovementResponse
import retrofit2.Response
import retrofit2.http.GET

interface BankApi {

    @GET("cuenta")
    suspend fun getAccount(): Response<AccountResponse>

    @GET("tarjetas")
    suspend fun getCards(): Response<CardResponse>

    @GET("saldos")
    suspend fun getBalances(): Response<BalanceResponse>

    @GET("movimientos")
    suspend fun getMovements(): Response<MovementResponse>
}