package com.example.onlineworkusecase.domain.model

data class BankAccountModel (
    val accountNumber: String,
    val valut: String,
    val balance: Double
)



data class BankTransactionModel(
    val date: String,
    val valut: String,
    val amount: Double,
)