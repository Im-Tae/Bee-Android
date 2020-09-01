package com.gsm.bee_assistant_android.ui.cafeteria

import androidx.lifecycle.MutableLiveData
import com.gsm.bee_assistant_android.base.BasePresenter
import com.gsm.bee_assistant_android.base.BaseView

class CafeteriaContract {
    interface View: BaseView<Presenter>

    interface Presenter: BasePresenter<View> {

        val mealList: MutableLiveData<ArrayList<String>>

        fun getMeal(year: Int, month: Int, day: Int)

        fun checkUserSchoolInfo(): Boolean
    }
}