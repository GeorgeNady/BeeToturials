package com.george.beetoturials.models.register

data class RegisterBody(
    val birthdate: String,
    val email: String,
    val fcmid: String,
    val gender: String,
    val password: String,
    val phone: Int,
    val username: String
)