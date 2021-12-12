package com.george.beetoturials.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.george.beetoturials.databinding.ActivityMainBinding
import com.george.beetoturials.models.login.LoginBody

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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



            }

        }
    }
}