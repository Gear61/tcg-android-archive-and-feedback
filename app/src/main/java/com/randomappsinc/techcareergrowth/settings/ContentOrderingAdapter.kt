package com.randomappsinc.techcareergrowth.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.LessonType

class ContentOrderingAdapter(private val lessonTypes: MutableList<LessonType>) :
    RecyclerView.Adapter<ContentOrderingAdapter.LessonTypeViewHolder>(), ItemTouchHelperAdapter {

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        val movedCard = lessonTypes.removeAt(fromPosition)
        lessonTypes.add(toPosition, movedCard)
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
        return lessonTypes.size
    }

    fun getLessonTypes(): List<LessonType> {
        return lessonTypes
    }

    inner class LessonTypeViewHolder internal constructor(view: View?) :
        RecyclerView.ViewHolder(view!!) {

        fun loadLessonType(position: Int) {

        }
    }
}
