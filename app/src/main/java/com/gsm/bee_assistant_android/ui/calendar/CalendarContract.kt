package com.gsm.bee_assistant_android.ui.calendar

import androidx.lifecycle.MutableLiveData
import com.gsm.bee_assistant_android.base.BasePresenter
import com.gsm.bee_assistant_android.base.BaseView

class CalendarContract {
    interface View: BaseView<Presenter>

    interface Presenter: BasePresenter<View> {

        val scheduleList: MutableLiveData<ArrayList<String>>

        fun getSchedule(year: Int, month: Int, day: Int)

        fun checkUserSchoolInfo(): Boolean
    }
}