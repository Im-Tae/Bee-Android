package com.gsm.bee_assistant_android.retrofit.domain.user

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("email")
    var email: String,
    @SerializedName("s_type")
    var type: String? = null,
    @SerializedName("s_region")
    var region: String? = null,
    @SerializedName("s_name")
    var name: String? = null,
    @SerializedName("access_token")
    var access_token: String? = null,
    @SerializedName("refresh_token")
    var refresh_token: String? = null,
    @SerializedName("iat")
    var iat: Int? = null
)