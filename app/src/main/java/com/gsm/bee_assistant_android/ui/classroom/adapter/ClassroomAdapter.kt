package com.gsm.bee_assistant_android.ui.classroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsm.bee_assistant_android.R
import com.gsm.bee_assistant_android.retrofit.domain.classroom.ResponseClassList
import com.gsm.bee_assistant_android.ui.classroom.ClassroomFragment
import com.gsm.bee_assistant_android.ui.classroom.adapter.viewholder.ClassroomViewHolder

class ClassroomAdapter(private val classroomFragment: ClassroomFragment, private val classroomList: ResponseClassList) : RecyclerView.Adapter<ClassroomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.classroom_card_item, parent, false)

        return ClassroomViewHolder(itemView)
    }

    override fun getItemCount(): Int = classroomList.classList.size

    override fun onBindViewHolder(holder: ClassroomViewHolder, position: Int) = holder.bindItems(classroomFragment, classroomList.classList[position], classroomList.classId[position])
}