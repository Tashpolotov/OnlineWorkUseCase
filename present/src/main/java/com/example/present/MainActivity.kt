package com.example.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.present.adapter.BankAdapter
import com.example.onlineworkusecase.presenter.viewmode.BankViewModel
import com.example.present.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = BankAdapter()
    private val viewModel by viewModels <BankViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.rv.adapter = adapter

        GlobalScope.launch {
            viewModel.bankAccount.collect{
                binding.tvBalance.text = it?.balance.toString()
                binding.tvNumber.text = it?.accountNumber
                binding.tvValut.text = it?.valut
            }
        }
            GlobalScope.launch {
                viewModel.bankTransAction.collect{
                    adapter.submitList(it)
                }
            }
        viewModel.loadBank()
    }
}