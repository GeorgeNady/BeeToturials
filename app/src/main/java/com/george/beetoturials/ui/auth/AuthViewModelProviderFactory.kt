package com.george.beetoturials.ui.auth

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.george.beetoturials.repositories.MainRepo

class AuthViewModelProviderFactory(
    val app:Application,
    val repo:MainRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(app,repo) as T
    }
}