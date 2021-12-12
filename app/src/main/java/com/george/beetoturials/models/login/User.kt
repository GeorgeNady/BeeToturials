package com.george.beetoturials.models.login

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("setting")
    val setting: Setting,
    @SerializedName("username")
    val username: String
)