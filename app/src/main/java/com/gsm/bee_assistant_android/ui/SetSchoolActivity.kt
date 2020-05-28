package com.gsm.bee_assistant_android.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.base.BaseActivity
import com.gsm.bee_assistant_android.databinding.ActivitySetSchoolBinding
import com.gsm.bee_assistant_android.ui.contract.SetSchoolContract
import dagger.android.AndroidInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_set_school.*
import javax.inject.Inject

class SetSchoolActivity : BaseActivity(), SetSchoolContract.View, AdapterView.OnItemSelectedListener {

    @Inject
    override lateinit var presenter : SetSchoolContract.Presenter

    override lateinit var binding: ActivitySetSchoolBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_school)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_set_school)
        binding.setschool = this

        AndroidInjection.inject(this)

        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeDisposable()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("spinnerTest", school_Kind_Spinner.selectedItem.toString())

        val schoolKind = school_Kind_Spinner.selectedItem.toString()
        val region = region_Spinner.selectedItem.toString()

        presenter.getIdValue(schoolKind, region)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) { }

    override fun init() {
        presenter.getUserInfo()
        school_Kind_Spinner.onItemSelectedListener = this
        region_Spinner.onItemSelectedListener = this
    }

    override fun showKeyboard() {}

    override fun hideKeyboard() {}

    override fun showToast(message: String) {}

    override fun startActivity(activityName: Class<*>) { startActivity(Intent(this, activityName)) }

}
