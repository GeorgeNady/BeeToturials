package com.george.beetoturials.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.george.beetoturials.repositories.MainRepo

class MainViewProviderFactory(
    val app:Application,
    val repo:MainRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app,repo) as T
    }
}