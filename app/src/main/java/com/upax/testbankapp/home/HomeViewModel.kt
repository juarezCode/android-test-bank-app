package com.upax.testbankapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {

    private var _account: MutableLiveData<Any> = MutableLiveData<Any>()
    val account: LiveData<Any> get() = _account
    private var _cards: MutableLiveData<Any> = MutableLiveData<Any>()
    val cards: LiveData<Any> get() = _cards
    private var _balances: MutableLiveData<Any> = MutableLiveData<Any>()
    val balances: LiveData<Any> get() = _balances
    private var _movements: MutableLiveData<Any> = MutableLiveData<Any>()
    val movements: LiveData<Any> get() = _movements

    suspend fun getAccount() {
        viewModelScope.launch {
            _account.value = repository.getAccount()
        }
    }

    suspend fun getCards() {
        viewModelScope.launch {
            _cards.value = repository.getCards()
        }
    }

    suspend fun getBalances() {
        viewModelScope.launch {
            _balances.value = repository.getBalances()
        }
    }

    suspend fun getMovements() {
        viewModelScope.launch {
            _movements.value = repository.getMovements()
        }
    }
}