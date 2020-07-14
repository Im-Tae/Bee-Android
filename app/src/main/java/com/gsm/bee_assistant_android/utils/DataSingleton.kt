package com.gsm.bee_assistant_android.utils

import com.gsm.bee_assistant_android.retrofit.domain.user.UserInfo

class DataSingleton {

    companion object {
        private var instance: DataSingleton? = null

        fun getInstance(): DataSingleton? {
            if (instance == null) instance = DataSingleton()

            return instance
        }

    }

    var _userInfo: UserInfo? = null
}