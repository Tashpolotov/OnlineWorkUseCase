package com.example.onlineworkusecase.presenter.viewmode

import androidx.lifecycle.ViewModel
import com.example.onlineworkusecase.domain.model.BankAccountModel
import com.example.onlineworkusecase.domain.model.BankTransactionModel
import com.example.onlineworkusecase.domain.usecase.BankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class BankViewModel(val bankUseCase: BankUseCase):ViewModel() {

    val _bankAccount = MutableStateFlow<BankAccountModel?>(null)
    val bankAccount = _bankAccount.asStateFlow()

    val _bankTransAction = MutableStateFlow<List<BankTransactionModel>>(emptyList())
    val bankTransAction = _bankTransAction.asStateFlow()

    fun loadBank() {
        GlobalScope.launch {
        val result = bankUseCase.getBank()
            _bankAccount.value = result.first
            _bankTransAction.value = result.second
        }
    }
}