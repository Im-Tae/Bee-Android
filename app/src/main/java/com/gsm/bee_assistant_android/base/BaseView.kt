package com.gsm.bee_assistant_android.base

import androidx.databinding.ViewDataBinding

interface BaseView<T> {

    val presenter : T
    val binding : ViewDataBinding

    fun init()

    fun hideKeyboard()

    fun showKeyboard()

    fun showToast(message: String)

    fun startActivity(activityName : Class<*>)
}