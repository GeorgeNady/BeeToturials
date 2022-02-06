package com.george.beetoturials.models.auth.register

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("fcmid") @Expose val fcmId: String
)