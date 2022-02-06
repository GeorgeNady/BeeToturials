package com.george.beetoturials.repositories

import com.george.beetoturials.models.auth.login.LoginBody
import com.george.beetoturials.models.auth.register.RegisterBody
import com.george.beetoturials.network.ApiClient.Companion.api
import com.george.beetoturials.network.BaseDataSource

class MainRepo : BaseDataSource() {

    suspend fun login(body: LoginBody) = safeApiCall { api.login(body) }

    suspend fun register(body: RegisterBody) = safeApiCall { api.register(body) }

}