package com.gsm.bee_assistant_android.retrofit.domain.user

data class UserInfo(
    var email: String,
    var s_type: String? = null,
    var s_region: String? = null,
    var s_name: String? = null,
    var access_token: String? = null,
    var refresh_token: String? = null,
    var iat: Int? = null
)