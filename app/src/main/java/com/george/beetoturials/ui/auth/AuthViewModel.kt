package com.george.beetoturials.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.george.beetoturials.models.login.LoginBody
import com.george.beetoturials.models.login.LoginResponse
import com.george.beetoturials.models.register.RegisterBody
import com.george.beetoturials.repositories.MainRepo
import com.george.beetoturials.utiles.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel(
    val app: Application,
    val repo: MainRepo
) : AndroidViewModel(app) {


    // live data // login response
    val loginResponse = MutableLiveData<Resource<LoginResponse>>()

    val registerResponse= MutableLiveData<Resource<LoginResponse>>()

    // call api
    suspend fun doLogin(body: LoginBody) = viewModelScope.launch {
        loginResponse.postValue(Resource.loading(null))
        try {
            loginResponse.postValue(repo.login(body))
        }catch (e:Exception) {}
    }
    suspend fun doRegister(body:RegisterBody)=viewModelScope.launch {
        registerResponse.postValue(Resource.loading(null))
        try {
            registerResponse.postValue(repo.register(body))
        }catch (e:Exception){

        }
    }


}