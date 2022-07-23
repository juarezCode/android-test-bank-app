package com.upax.testbankapp.home

import com.upax.testbankapp.api.BankApi
import com.upax.testbankapp.models.Account
import com.upax.testbankapp.models.Balance
import com.upax.testbankapp.models.Card
import com.upax.testbankapp.models.Movement
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val api: BankApi
) {
    suspend fun getAccount(): Account {
        val response = api.getAccount()
        return response.body()!!.cuenta[0]
    }

    suspend fun getCards(): List<Card> {
        val response = api.getCards()
        return response.body()!!.tarjetas
    }

    suspend fun getBalances(): List<Balance> {
        val response = api.getBalances()
        return response.body()!!.saldos
    }

    suspend fun getMovements(): List<Movement> {
        val response = api.getMovements()
        return response.body()!!.movimientos
    }
}