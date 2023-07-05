package com.example.onlineworkusecase.domain.repository

import com.example.onlineworkusecase.domain.model.BankAccountModel
import com.example.onlineworkusecase.domain.model.BankTransactionModel

interface BankRepository {

    fun getAccount() : BankAccountModel

    fun getTransAction() : List<BankTransactionModel>
}