package com.gsm.bee_assistant_android.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.databinding.ViewDataBinding
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.base.BaseDialogFragment
import com.gsm.bee_assistant_android.ui.contract.SetSchoolDialogContract
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.search_bar.*
import kotlinx.android.synthetic.main.set_school_dialog.*
import javax.inject.Inject

class SetSchoolDialogFragment : BaseDialogFragment(), SetSchoolDialogContract.View {

    var listener: (String) -> Unit = { _ -> }

    override lateinit var binding: ViewDataBinding

    @Inject
    override lateinit var presenter: SetSchoolDialogContract.Presenter

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

        presenter.getSchoolName()

//        val adapter = context?.let {
//            ArrayAdapter (
//                it,
//                android.R.layout.simple_dropdown_item_1line,
//                schoolNameList
//            )
//        }
//
//        schoolSearchTextView.let {
//            it.threshold = 1
//            it.setAdapter(adapter)
//        }
    }

    override fun showToast(message: String) {}

    override fun startActivity(activityName: Class<*>) {}
}