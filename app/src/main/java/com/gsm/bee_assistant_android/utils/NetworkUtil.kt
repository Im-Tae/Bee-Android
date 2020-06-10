package com.gsm.bee_assistant_android.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

@Suppress("DEPRECATION")
class NetworkUtil @Inject constructor(private val context: Context) {

    fun networkInfo(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo ?: null

        return networkInfo != null && networkInfo.isConnected
    }
}