package com.upax.testbankapp.home

import com.upax.testbankapp.api.BankApi
import com.upax.testbankapp.models.Account
import com.upax.testbankapp.models.Balance
import com.upax.testbankapp.models.Card
import com.upax.testbankapp.models.Movement
import kotlinx.coroutines.delay
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val api: BankApi
) {
    suspend fun getAccount(): Account {
        delay(1000)
        val response = api.getAccount()
        return response.body()!!.cuenta[0]
    }

    suspend fun getCards(): List<Card> {
        delay(1000)
        val response = api.getCards()
        return response.body()!!.tarjetas
    }

    suspend fun getBalances(): List<Balance> {
        delay(1000)
        val response = api.getBalances()

        val balances = mutableListOf<Balance>()
        balances.addAll(response.body()!!.saldos)
        balances.add(Balance(100, "45962781103", 28564, 100))
        balances.add(Balance(100, "69987236587", 0, 100))

        return balances
    }

    suspend fun getMovements(): List<Movement> {
        delay(1000)
        val response = api.getMovements()
        return response.body()!!.movimientos
    }
}