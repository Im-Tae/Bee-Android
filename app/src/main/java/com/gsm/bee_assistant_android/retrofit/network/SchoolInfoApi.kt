package com.gsm.bee_assistant_android.retrofit.network

import com.gsm.bee_assistant_android.retrofit.domain.SchoolInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolInfoApi {

    @GET("getOpenApi")
    fun getSchoolInfo(
        @Query("apiKey") apiKey: String,
        @Query("svcType") svcType: String = "api",
        @Query("svcCode") svcCode: String = "SCHOOL",
        @Query("contentType") contentType: String = "json",
        @Query("gubun") schoolKind: String,
        @Query("region") region: String,
        @Query("sch1") schoolType: String
    ) : Observable<SchoolInfo>
}