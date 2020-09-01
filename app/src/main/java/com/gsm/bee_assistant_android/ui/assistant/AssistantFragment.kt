package com.gsm.bee_assistant_android.ui.assistant

import com.gsm.bee_assistant_android.BR
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.base.BaseFragment
import com.gsm.bee_assistant_android.databinding.FragmentAssistantBinding
import javax.inject.Inject

class AssistantFragment : BaseFragment<FragmentAssistantBinding>(
    R.layout.fragment_assistant,
    BR.assistant
), AssistantContract.View {

    @Inject
    override lateinit var presenter: AssistantContract.Presenter

    override fun init() {}

    override fun showProgress() {}

    override fun hideProgress() {}

    override fun showToast(message: String) {}

    override fun startActivity(activityName: Class<*>) {}
}