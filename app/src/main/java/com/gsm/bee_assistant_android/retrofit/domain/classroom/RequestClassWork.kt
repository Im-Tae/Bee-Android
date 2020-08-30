package com.gsm.bee_assistant_android.retrofit.domain.classroom

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class RequestClassWork(
    val access_token: String,
    val refresh_token: String,
    @SerializedName("classid")
    val classId: BigInteger
)