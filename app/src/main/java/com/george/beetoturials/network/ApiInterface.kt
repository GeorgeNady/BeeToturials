package com.george.beetoturials.network

import com.george.beetoturials.models.auth.login.LoginBody
import com.george.beetoturials.models.auth.AuthResponse
import com.george.beetoturials.models.auth.register.RegisterBody
import retrofit2.Response
import retrofit2.http.*

@Suppress("FunctionName")
interface ApiInterface {

    @POST("auth/login")
    suspend fun login(@Body body:LoginBody) : Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(@Body register: RegisterBody): Response<AuthResponse>

}