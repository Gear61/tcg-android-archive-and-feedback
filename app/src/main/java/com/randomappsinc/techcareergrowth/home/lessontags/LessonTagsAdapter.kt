package com.randomappsinc.techcareergrowth.home.lessontags

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
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
        private val numLessonsText: TextView = itemView.findViewById(R.id.num_lessons_text)
        private val completionPercent: TextView = itemView.findViewById(R.id.completion_percent)

        fun bind(position: Int) {
            val viewModel = viewModels[position]
            lessonTag.text = viewModel.tagLabel
            numLessonsText.text = viewModel.getNumLessonText(context = itemView.context)
            completionPercent.text = viewModel.getCompletionRateText()
            val completionTextColor = viewModel.getCompletionTextColor()
            completionPercent.setTextColor(completionTextColor)

            val completionBackground: GradientDrawable = completionPercent.background as GradientDrawable
            val strokeWidthPixels = itemView.context.resources.getDimensionPixelSize(R.dimen.completion_percent_stroke_width)
            completionBackground.setStroke(strokeWidthPixels, completionTextColor)

            itemView.setOnClickListener {
                listener.onTagClicked(viewModel.tag)
            }
        }
    }
}