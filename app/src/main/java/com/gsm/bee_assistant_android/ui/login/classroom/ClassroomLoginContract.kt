package com.gsm.bee_assistant_android.ui.login.classroom

import com.gsm.bee_assistant_android.base.BasePresenter
import com.gsm.bee_assistant_android.base.BaseView

class ClassroomLoginContract {

    interface View : BaseView<Presenter> {

        var setSetVisibility: Boolean

        fun onClickClassroomButton()

        fun onClickSkipButton()
    }

    interface Presenter : BasePresenter<View> {

    }
}