package com.george.beetoturials.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.george.beetoturials.models.login.LoginBody
import com.george.beetoturials.models.login.LoginResponse
import com.george.beetoturials.repositories.MainRepo
import com.george.beetoturials.utiles.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val app: Application,
    val repo: MainRepo
) : AndroidViewModel(app) {


    // live data // login response
    val loginResponse = MutableLiveData<Resource<LoginResponse>>()

    // call api
    suspend fun doLogin(body: LoginBody) = viewModelScope.launch {
        loginResponse.postValue(Resource.loading(null))
        try {
            loginResponse.postValue(repo.login(body))
        }catch (e:Exception) {}
    }


}