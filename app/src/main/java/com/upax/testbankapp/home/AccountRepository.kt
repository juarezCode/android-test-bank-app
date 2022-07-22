package com.upax.testbankapp.home

import com.upax.testbankapp.api.BankApi
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val api: BankApi
) {
    suspend fun getAccount() {

    }

    suspend fun getCards() {

    }

    suspend fun getBalances() {

    }

    suspend fun getMovements() {

    }
}