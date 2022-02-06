package com.george.beetoturials.models.auth.login

import com.google.gson.annotations.SerializedName

data class LoginBody(
    @SerializedName("email") val email: String,
    @SerializedName("password") val pass: String,
    @SerializedName("fcmid") val fcmid:String
)
