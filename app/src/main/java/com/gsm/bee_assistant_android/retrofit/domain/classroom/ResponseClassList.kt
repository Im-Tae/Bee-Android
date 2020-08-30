package com.gsm.bee_assistant_android.retrofit.domain.classroom

import com.google.gson.annotations.SerializedName

data class ResponseClassList(
    @SerializedName("classlist")
    val classList: ArrayList<String>,

    @SerializedName("classid")
    val classId: ArrayList<String>
)