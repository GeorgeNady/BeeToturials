package com.george.beetoturials.ui.auth

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.george.beetoturials.R
import com.george.beetoturials.base.BaseActivity
import com.george.beetoturials.base.BaseApplication.Companion.baseApplication
import com.george.beetoturials.databinding.ActivityAuthBinding
import com.george.beetoturials.repositories.MainRepo

class AuthActivity : BaseActivity<ActivityAuthBinding>(
    ActivityAuthBinding::inflate
) {

    override val TAG = this.javaClass.name
    lateinit var navController: NavController
    lateinit var authViewModel: AuthViewModel

    override fun beforeCreatingView() {
        setTheme(R.style.Theme_Hosha)
    }

    override fun initialization() {
        val viewModelFactory = AuthViewModelProviderFactory(baseApplication, MainRepo())
        authViewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
        navController = setupNavController(R.id.fragmentContainerView)
    }

    override fun setListener() {
    }

}