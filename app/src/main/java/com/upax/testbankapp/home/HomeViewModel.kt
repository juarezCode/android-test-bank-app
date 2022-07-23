package com.upax.testbankapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upax.testbankapp.models.Account
import com.upax.testbankapp.models.Balance
import com.upax.testbankapp.models.Card
import com.upax.testbankapp.models.Movement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {

    private var _account: MutableLiveData<Account> = MutableLiveData<Account>()
    val account: LiveData<Account> get() = _account
    private var _cards: MutableLiveData<List<Card>> = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> get() = _cards
    private var _balances: MutableLiveData<List<Balance>> = MutableLiveData<List<Balance>>()
    val balances: LiveData<List<Balance>> get() = _balances
    private var _movements: MutableLiveData<List<Movement>> = MutableLiveData<List<Movement>>()
    val movements: LiveData<List<Movement>> get() = _movements

    fun getAccount() {
        viewModelScope.launch {
            _account.value = repository.getAccount()
        }
    }

    fun getCards() {
        viewModelScope.launch {
            _cards.value = repository.getCards()
        }
    }

    fun getBalances() {
        viewModelScope.launch {
            _balances.value = repository.getBalances()
        }
    }

    fun getMovements() {
        viewModelScope.launch {
            _movements.value = repository.getMovements()
        }
    }
}