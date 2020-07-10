package com.gsm.bee_assistant_android.retrofit.domain.user

import com.google.gson.annotations.SerializedName

data class UserToken(
    @SerializedName("x-access-token")
    val token: String
)