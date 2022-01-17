package com.randomappsinc.techcareergrowth.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson

open class LessonsAdapter(
    private val lessons: List<Lesson>,
    protected var selectionListener: SelectionListener
) : RecyclerView.Adapter<LessonsAdapter.ViewHolder>()  {

    interface SelectionListener {
        fun onLessonClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_item_cell,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    fun onLessonCompleted(lessonPosition: Int) {
        lessons[lessonPosition].isCompleted = true
        notifyItemChanged(lessonPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lessonName: TextView = itemView.findViewById(R.id.lesson_name)
        private val completionIcon: TextView = itemView.findViewById(R.id.completion_state)

        fun bind(position: Int) {
            lessonName.setText(lessons[position].nameResId)
            if (lessons[position].isCompleted) {
                completionIcon.setText(R.string.green_check_icon)
            } else {
                completionIcon.setText(R.string.red_x_icon)
            }

            itemView.setOnClickListener {
                selectionListener.onLessonClicked(bindingAdapterPosition)
            }
        }
    }
}
