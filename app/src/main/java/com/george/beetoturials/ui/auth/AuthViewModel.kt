package com.george.beetoturials.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.george.beetoturials.models.auth.AuthResponse
import com.george.beetoturials.models.auth.login.LoginBody
import com.george.beetoturials.models.auth.register.RegisterBody
import com.george.beetoturials.repositories.MainRepo
import com.george.beetoturials.utiles.Resource
import kotlinx.coroutines.launch

class AuthViewModel(
    val app: Application,
    private val repo: MainRepo
) : AndroidViewModel(app) {



    // call api
    suspend fun login(body: LoginBody) : LiveData<Resource<AuthResponse>> {
        val loginResponse = MutableLiveData<Resource<AuthResponse>>()
        viewModelScope.launch {
            loginResponse.value = Resource.loading(null)
            try {
                loginResponse.value = repo.login(body)
            } catch (e: Exception) {
                loginResponse.value = Resource.failed(e.toString())
            }
        }
        return loginResponse
    }


    // call api
    suspend fun register(body: RegisterBody): LiveData<Resource<AuthResponse>> {
        val registerResponse = MutableLiveData<Resource<AuthResponse>>()
        viewModelScope.launch {
            registerResponse.value = Resource.loading(null)
            try {
                registerResponse.value = repo.register(body)
            } catch (e: Exception) {
                registerResponse.value = Resource.failed(e.toString())
            }
        }
        return registerResponse
    }


}