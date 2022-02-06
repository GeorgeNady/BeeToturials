package com.george.beetoturials.models.auth


import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("token") val token: String,
    @SerializedName("user") val user: User
)

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


data class Setting(
    @SerializedName("follow_participation_notification")
    val followParticipationNotification: Boolean,
    @SerializedName("hosha_updates_notfication")
    val hoshaUpdatesNotfication: Boolean,
    @SerializedName("language")
    val language: String,
    @SerializedName("new_comments_notification")
    val newCommentsNotification: Boolean,
    @SerializedName("new_followers_notification")
    val newFollowersNotification: Boolean,
    @SerializedName("private_profile")
    val privateProfile: Boolean,
    @SerializedName("voting_result_changes_notification")
    val votingResultChangesNotification: Boolean
)