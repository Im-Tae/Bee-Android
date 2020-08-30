package com.gsm.bee_assistant_android.ui.splash

import com.gsm.bee_assistant_android.base.BasePresenter
import com.gsm.bee_assistant_android.base.BaseView
import com.gsm.bee_assistant_android.retrofit.domain.user.UserInfo

class SplashContract {

    interface View : BaseView<Presenter> {

        fun finishActivity()
    }

    interface Presenter : BasePresenter<View> {

        fun checkUserInfo()

        fun getUserInfo()

        fun checkUserInfoToChangeActivity(userInfo: UserInfo)
    }
}