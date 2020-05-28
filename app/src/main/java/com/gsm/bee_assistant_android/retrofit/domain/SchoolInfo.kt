package com.gsm.bee_assistant_android.retrofit.domain

data class SchoolInfo(
    val dataSearch : DataSearch?= null
)

data class DataSearch(
    val content : ArrayList<Content>? = null
)

data class Content (
    val link: String? = null,
    val schoolGubun: String? = null,
    val adres: String? = null,
    val schoolName: String? = null,
    val region: String? = null,
    val totalCount: String? = null,
    val estType: String? = null,
    val seq: String? = null
)