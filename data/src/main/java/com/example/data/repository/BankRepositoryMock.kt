package com.example.onlineworkusecase.data.repository

import com.example.onlineworkusecase.domain.model.BankAccountModel
import com.example.onlineworkusecase.domain.model.BankTransactionModel
import com.example.onlineworkusecase.domain.repository.BankRepository

class BankRepositoryMock:BankRepository {
    override fun getAccount(): BankAccountModel {
        return BankAccountModel("Diana", "Euro", 15586.8)
    }

    override fun getTransAction(): List<BankTransactionModel> {
        return listOf(BankTransactionModel("16:20", "Som", 4889.8))
    }
}