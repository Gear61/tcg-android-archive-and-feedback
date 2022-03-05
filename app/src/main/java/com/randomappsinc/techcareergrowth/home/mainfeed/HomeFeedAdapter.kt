package com.randomappsinc.techcareergrowth.home.mainfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.contentproviders.LessonProvider
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag

open class HomeFeedAdapter(
    val lessonTags: List<LessonTag>,
    var listener: Listener?,
    val positionToAdapter: MutableMap<Int, LessonGalleryAdapter> = mutableMapOf()
) : RecyclerView.Adapter<HomeFeedAdapter.ViewHolder>()  {

    interface Listener {
        fun onLessonClicked(lesson: Lesson)

        fun onLessonTypeClicked(tag: LessonTag)
    }

    fun clear() {
        this.listener = null
    }

    fun onLessonCompleted(lessonId: String) {
        for (adapter in positionToAdapter.values) {
            adapter.onLessonCompleted(lessonId = lessonId)
        }
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
        return lessonTags.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lessonTypeTitle: TextView = itemView.findViewById(R.id.lesson_type)
        private val arrowButton: View = itemView.findViewById(R.id.arrow_button)
        private val lessonGallery: RecyclerView = itemView.findViewById(R.id.lesson_gallery)

        fun bind(position: Int) {
            lessonTypeTitle.setText(lessonTags[position].overallLabelId)
            lessonTypeTitle.setOnClickListener {
                listener?.onLessonTypeClicked(lessonTags[position])
            }
            arrowButton.setOnClickListener {
                listener?.onLessonTypeClicked(lessonTags[position])
            }

            val lessons = LessonProvider.getLessonList(
                tag = lessonTags[position],
                context = itemView.context
            )

            var adapter = positionToAdapter[position]
            if (adapter == null) {
                adapter = LessonGalleryAdapter(
                    lessons = lessons,
                    listener = listener
                )
                positionToAdapter[position] = adapter
            }
            lessonGallery.adapter = adapter
        }
    }
}
