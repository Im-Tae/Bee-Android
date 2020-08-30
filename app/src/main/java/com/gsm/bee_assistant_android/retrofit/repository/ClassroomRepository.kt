package com.gsm.bee_assistant_android.retrofit.repository

import com.gsm.bee_assistant_android.retrofit.domain.classroom.*
import com.gsm.bee_assistant_android.retrofit.network.ClassroomApi
import com.gsm.bee_assistant_android.utils.DataSingleton
import com.gsm.bee_assistant_android.utils.NetworkUtil
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import java.math.BigInteger
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ClassroomRepository @Inject constructor(
    private val classroomApi: ClassroomApi,
    private val networkStatus: NetworkUtil
) {

    private val userInfo = DataSingleton.getInstance()?._userInfo

    fun getClassroomLink(): Call<ClassroomLink> =
        classroomApi.getClassroomLink()

    fun getClassroomToken(token: String): Single<ClassroomToken> =
        classroomApi.getClassroomToken(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retryWhen {
                Flowable.interval(3, TimeUnit.SECONDS)
                    .onBackpressureBuffer()
                    .retryUntil {
                        if(networkStatus.networkInfo())
                            return@retryUntil true

                        false
                    }
            }

    fun getClassList(): Single<ResponseClassList> =
        classroomApi.getClassList(RequestClassList(userInfo?.access_token.toString(), userInfo?.refresh_token.toString()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retryWhen {
                Flowable.interval(3, TimeUnit.SECONDS)
                    .onBackpressureBuffer()
                    .retryUntil {
                        if(networkStatus.networkInfo())
                            return@retryUntil true

                        false
                    }
            }

    fun getClassWork(classId: BigInteger): Single<ResponseClassWork> =
        classroomApi.getClassWork(RequestClassWork(userInfo?.access_token.toString(), userInfo?.refresh_token.toString(), classId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retryWhen {
                Flowable.interval(3, TimeUnit.SECONDS)
                    .onBackpressureBuffer()
                    .retryUntil {
                        if(networkStatus.networkInfo())
                            return@retryUntil true

                        false
                    }
            }
}