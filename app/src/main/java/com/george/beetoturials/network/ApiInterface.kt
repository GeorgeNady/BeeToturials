package com.george.beetoturials.network

import com.george.beetoturials.models.login.LoginBody
import com.george.beetoturials.models.login.LoginResponse
import retrofit2.Response
import retrofit2.http.*

@Suppress("FunctionName")
interface ApiInterface {

    @POST("auth/login")
    suspend fun login(@Body body:LoginBody) : Response<LoginResponse>

}