package com.george.beetoturials.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.george.beetoturials.databinding.ActivityMainBinding
import com.george.beetoturials.models.login.LoginBody
import com.george.beetoturials.repositories.MainRepo
import com.george.beetoturials.utiles.Resource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MainViewProviderFactory(application, MainRepo())
        mainViewModel = ViewModelProvider(this,factory)[MainViewModel::class.java]

        binding.apply {
            btnLogin.setOnClickListener {
                Log.d("MAinActivity", "onCreate: email: ${etEmail.text} pass: ${etPassword.text}")
            }
        }

        binding.apply {
            btnLogin.setOnClickListener {

                val body = LoginBody(
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    "fcmid"
                )

                lifecycleScope.launchWhenCreated {
                    mainViewModel.doLogin(body)
                }

            }

            mainViewModel.loginResponse.observe(this@MainActivity) {
                when (it.success) {
                    Resource.Status.LOADING -> {
                        Log.d(TAG, "onCreate: data ${it.data} message ${it.message}")
                    }
                    Resource.Status.SUCCESS -> {
                        Log.d(TAG, "onCreate: data ${it.data} message ${it.message}")
                    }
                    Resource.Status.ERROR -> {
                        Log.d(TAG, "onCreate: data ${it.data} message ${it.message}")
                    }
                    Resource.Status.FAILURE -> {
                        Log.d(TAG, "onCreate: data ${it.data} message ${it.message}")
                    }
                }
            }

        }
    }
}