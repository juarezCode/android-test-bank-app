package com.upax.testbankapp.addcard

import com.upax.testbankapp.api.BankApi
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val api: BankApi
) {
    
}