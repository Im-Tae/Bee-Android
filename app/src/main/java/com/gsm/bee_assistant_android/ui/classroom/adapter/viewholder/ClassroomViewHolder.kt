package com.gsm.bee_assistant_android.ui.classroom.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gsm.bee_assistant_android.ui.classroom.ClassroomFragment
import kotlinx.android.synthetic.main.classroom_card_item.view.*

class ClassroomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(classroomFragment: ClassroomFragment, classList: String, classId: String) {

        itemView.card_text.text = classList
        itemView.card_linearLayout.setOnClickListener { classroomFragment.presenter.getClassWork(classId) }
    }
}