package com.randomappsinc.techcareergrowth.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType

open class HomepageAdapter(
    val lessonTypes: List<LessonType>,
    var listener: Listener?
) : RecyclerView.Adapter<HomepageAdapter.ViewHolder>()  {

    interface Listener {
        fun onLessonClicked(lesson: Lesson)
    }

    fun clear() {
        this.listener = null
    }

    fun onLessonCompleted() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_gallery_item_cell,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return lessonTypes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lessonName: TextView = itemView.findViewById(R.id.lesson_type)
        private val lessonGallery: RecyclerView = itemView.findViewById(R.id.lesson_gallery)

        fun bind(position: Int) {
            lessonName.setText(lessonTypes[position].overallLabelId)
        }
    }
}