package com.gsm.bee_assistant_android.ui.classroom

import androidx.lifecycle.MutableLiveData
import com.gsm.bee_assistant_android.base.BasePresenter
import com.gsm.bee_assistant_android.base.BaseView
import com.gsm.bee_assistant_android.retrofit.domain.classroom.ResponseClassList

class ClassroomContract {
    interface View: BaseView<Presenter> {

        fun showClassWork(classList: ArrayList<ArrayList<String>>)
    }

    interface Presenter: BasePresenter<View> {

        val classList : MutableLiveData<ResponseClassList>

        fun getClassList()

        fun checkUserClassroomTokenInfo(): Boolean

        fun getClassWork(classId: String)
    }
}