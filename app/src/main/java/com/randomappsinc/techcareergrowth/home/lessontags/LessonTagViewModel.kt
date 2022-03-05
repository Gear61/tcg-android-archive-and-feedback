package com.randomappsinc.techcareergrowth.home.lessontags

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag

data class LessonTagViewModel(
    val tag: LessonTag,
    val lessons: List<Lesson>,
    val tagLabel: String
) {

    fun getNumLessonText(context: Context): String {
        return context.getString(R.string.num_lessons, lessons.size)
    }
}
