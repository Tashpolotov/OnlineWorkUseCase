package com.example.onlineworkusecase.domain.usecase

import com.example.onlineworkusecase.domain.model.BankAccountModel
import com.example.onlineworkusecase.domain.model.BankTransactionModel
import com.example.onlineworkusecase.domain.repository.BankRepository


class BankUseCase  constructor(val bankRepository: BankRepository) {

    fun getBank() : Pair<BankAccountModel, List<BankTransactionModel>>{

        val account = bankRepository.getAccount()
        val transAction = bankRepository.getTransAction()
        return Pair(account, transAction)

    }
}