package com.randomappsinc.techcareergrowth.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson

open class LessonGalleryAdapter(
    val lessons: List<Lesson>,
    var listener: HomepageAdapter.Listener?
) : RecyclerView.Adapter<LessonGalleryAdapter.ViewHolder>() {

    fun onLessonCompleted() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_card_item,
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lessonName: TextView = itemView.findViewById(R.id.lesson_name)
        private val lessonThumbnail: ImageView = itemView.findViewById(R.id.lesson_thumbnail)
        private val completionIcon: TextView = itemView.findViewById(R.id.completion_icon)

        fun bind(position: Int) {
            val lesson = lessons[position]
            lessonName.setText(lesson.nameResId)
            lessonThumbnail.load(lesson.getYouTubeThumbnailUrl())
            if (lesson.isCompleted) {
                completionIcon.setText(R.string.green_check_icon)
            } else {
                completionIcon.setText(R.string.red_x_icon)
            }
        }
    }
}
