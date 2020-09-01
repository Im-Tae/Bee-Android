package com.gsm.bee_assistant_android.ui.calendar

import androidx.lifecycle.MutableLiveData
import com.gsm.bee_assistant_android.retrofit.repository.SchoolRepository
import com.gsm.bee_assistant_android.utils.DataSingleton
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CalendarPresenter @Inject constructor(
    override val view: CalendarContract.View,
    override val compositeDisposable: CompositeDisposable,
    private val schoolApi: SchoolRepository
): CalendarContract.Presenter {

    override val scheduleList = MutableLiveData<ArrayList<String>>()

    override fun getSchedule(year: Int, month: Int, day: Int) {

        view.showProgress()

        compositeDisposable.clear()

        addDisposable(
            schoolApi.getSchedule(year, month, day)
                .map {
                    if (it.today.contains(","))
                        it.today.split(",")
                    else
                        listOf(it.today)
                }
                .map {
                    val scheduleArrayList = arrayListOf<String>()

                    for (i in it.indices)
                        scheduleArrayList.add(it[i])

                    return@map scheduleArrayList
                }
                .subscribe(
                    {
                        scheduleList.postValue(it)
                        view.hideProgress()
                    }, {}
                )
        )
    }

    override fun checkUserSchoolInfo(): Boolean {

        val userInfo = DataSingleton.getInstance()?._userInfo

        if (userInfo?.type != "")
            return true

        return false
    }

    override fun addDisposable(disposable: Disposable) { compositeDisposable.add(disposable) }

    override fun disposeDisposable() = compositeDisposable.dispose()
}