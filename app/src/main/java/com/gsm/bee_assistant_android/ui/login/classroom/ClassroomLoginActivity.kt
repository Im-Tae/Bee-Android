package com.gsm.bee_assistant_android.ui.login.classroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.databinding.ActivityClassroomLoginBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class ClassroomLoginActivity : AppCompatActivity(), ClassroomLoginContract.View {

    @Inject
    override lateinit var presenter: ClassroomLoginContract.Presenter

    override lateinit var binding: ActivityClassroomLoginBinding

    override var setSetVisibility: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_classroom_login)
        binding.classroomLogin = this

        AndroidInjection.inject(this)
    }

    override fun init() {

    }

    override fun showToast(message: String) {

    }

    override fun startActivity(activityName: Class<*>) {

    }

    override fun onClickClassroomButton() {

    }

    override fun onClickSkipButton() {
        
    }
}