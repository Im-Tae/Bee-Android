package com.gsm.bee_assistant_android.retrofit.network

import com.gsm.bee_assistant_android.retrofit.domain.classroom.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ClassroomApi {

    @GET("classroom")
    fun getClassroomLink(): Call<ClassroomLink>

    @FormUrlEncoded
    @POST("classroom")
    fun getClassroomToken(@Field("code") code: String): Single<ClassroomToken>

    @POST("classroom/class")
    fun getClassList(@Body requestClassroomList: RequestClassList): Single<ResponseClassList>

    @POST("classroom/work")
    fun getClassWork(@Body requestClassWork: RequestClassWork): Single<ResponseClassWork>
}