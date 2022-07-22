package com.upax.testbankapp.api

import retrofit2.Response
import retrofit2.http.GET

interface BankApi {

    @GET("cuenta")
    suspend fun getAccount(): Response<Any>

    @GET("tarjetas")
    suspend fun getCards(): Response<Any>

    @GET("saldos")
    suspend fun getBalances(): Response<Any>

    @GET("movimientos")
    suspend fun getMovements(): Response<Any>
}