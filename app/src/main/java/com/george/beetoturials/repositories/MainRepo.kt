package com.george.beetoturials.repositories

import com.george.beetoturials.models.login.LoginBody
import com.george.beetoturials.network.ApiClient.Companion.api
import com.george.beetoturials.network.BaseDataSource

class MainRepo : BaseDataSource() {

    // get data from data source

    // get data from local database

    suspend fun login(body: LoginBody) = safeApiCall { api.login(body) }

    suspend fun resgester(body: LoginBody) = safeApiCall { api.login(body) }

}