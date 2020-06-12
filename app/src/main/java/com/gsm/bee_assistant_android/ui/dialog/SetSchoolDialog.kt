package com.gsm.bee_assistant_android.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.gsm.bee_assistant_android.R
import kotlinx.android.synthetic.main.set_school_dialog.*

class SetSchoolDialog : DialogFragment() {

    var listener: (String) -> Unit = { _ -> }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.set_school_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        confirmButton.setOnClickListener {

            dismiss()

            //listener.invoke(school_Name_spinner.selectedItem.toString())
        }

        cancelButton.setOnClickListener { dismiss() }
    }
}