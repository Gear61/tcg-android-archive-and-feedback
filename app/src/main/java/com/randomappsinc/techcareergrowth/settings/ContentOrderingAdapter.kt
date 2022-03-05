package com.randomappsinc.techcareergrowth.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.LessonTag

class ContentOrderingAdapter(val lessonTags: MutableList<LessonTag>) :
    RecyclerView.Adapter<ContentOrderingAdapter.LessonTypeViewHolder>(), ItemTouchHelperAdapter {

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        val movedCard = lessonTags.removeAt(fromPosition)
        lessonTags.add(toPosition, movedCard)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LessonTypeViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.movable_lesson_type,
            parent,
            false
        )
        return LessonTypeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LessonTypeViewHolder, position: Int) {
        holder.loadLessonType(position)
    }

    override fun getItemCount(): Int {
        return lessonTags.size
    }

    inner class LessonTypeViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val lessonTitle: TextView = itemView.findViewById(R.id.lesson_type)

        fun loadLessonType(position: Int) {
            lessonTitle.setText(lessonTags[position].overallLabelId)
        }
    }
}
