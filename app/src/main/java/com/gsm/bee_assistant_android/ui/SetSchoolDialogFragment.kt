package com.gsm.bee_assistant_android.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.base.BaseDialogFragment
import com.gsm.bee_assistant_android.di.app.MyApplication
import com.gsm.bee_assistant_android.retrofit.domain.SchoolInfo
import com.gsm.bee_assistant_android.retrofit.network.SchoolInfoApi
import com.gsm.bee_assistant_android.ui.contract.SetSchoolDialogContract
import com.gsm.bee_assistant_android.utils.NetworkUtil
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.search_bar.*
import kotlinx.android.synthetic.main.set_school_dialog.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SetSchoolDialogFragment : BaseDialogFragment(), SetSchoolDialogContract.View {

    @Inject
    override lateinit var presenter: SetSchoolDialogContract.Presenter

    override lateinit var binding: ViewDataBinding

    var listener: (String) -> Unit = { _ -> }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.set_school_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        init()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        confirmButton.setOnClickListener {

            dismiss()

            listener.invoke(schoolSearchTextView.text.toString())
        }

        cancelButton.setOnClickListener { dismiss() }
    }

    override fun onDestroy() {
        presenter.disposeDisposable()
        super.onDestroy()
    }

    override fun init() {

        lateinit var schoolNameList: MutableList<String>

        presenter.addDisposable(
            Observable.just(presenter.getSchoolName())
                .subscribe { schoolNameList = it }
        )

        val adapter = context?.let {
            ArrayAdapter (
                it,
                android.R.layout.simple_dropdown_item_1line,
                schoolNameList
            )
        }

        schoolSearchTextView.let {
            it.threshold = 1
            it.setAdapter(adapter)
        }

    }

    override fun showToast(message: String) {}

    override fun startActivity(activityName: Class<*>) {}
}