package com.gsm.bee_assistant_android.retrofit.repository

import com.gsm.bee_assistant_android.retrofit.domain.classroom.ClassroomLink
import com.gsm.bee_assistant_android.retrofit.domain.classroom.ClassroomToken
import com.gsm.bee_assistant_android.retrofit.network.ClassroomApi
import com.gsm.bee_assistant_android.utils.NetworkUtil
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ClassroomRepository @Inject constructor(
    private val classroomApi: ClassroomApi,
    private val networkStatus: NetworkUtil
) {

    fun getClassroomLink(): Call<ClassroomLink> =
        classroomApi.getClassroomLink()

    fun getClassroomToken(token: String): Single<ClassroomToken> =
        classroomApi.getClassroomToken(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retryWhen {
                Flowable.interval(3, TimeUnit.SECONDS)
                    .retryUntil {
                        if(networkStatus.networkInfo())
                            return@retryUntil true

                        false
                    }
            }
}