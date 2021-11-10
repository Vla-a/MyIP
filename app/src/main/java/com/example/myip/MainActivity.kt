package com.example.myip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myip.databinding.ActivityMainBinding
import com.example.myip.viewModel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            myViewModel.userLiveData.observe(this, {
                binding.ip.text = "IP: ${it.ip}"
            })
        }
    }
}