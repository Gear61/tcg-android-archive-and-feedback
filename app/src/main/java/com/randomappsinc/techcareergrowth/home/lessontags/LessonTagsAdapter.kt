package com.randomappsinc.techcareergrowth.home.lessontags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag

open class LessonTagsAdapter(
    val viewModels: List<LessonTagViewModel>,
    var listener: Listener
) : RecyclerView.Adapter<LessonTagsAdapter.ViewHolder>() {

    interface Listener {
        fun onTagClicked(tag: LessonTag)
    }

    fun onLessonCompleted(lessonId: String) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_tag_item,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lessonTag: TextView = itemView.findViewById(R.id.lesson_tag)
        private val lessonName: TextView = itemView.findViewById(R.id.lesson_name)

        fun bind(position: Int) {
            val viewModel = viewModels[position]
            lessonName.text = viewModel.tagLabel
        }
    }
}