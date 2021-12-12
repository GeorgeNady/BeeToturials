package com.george.beetoturials.models.login

import com.google.gson.annotations.SerializedName


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