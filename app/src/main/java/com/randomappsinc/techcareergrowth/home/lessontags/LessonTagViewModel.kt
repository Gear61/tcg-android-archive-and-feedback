package com.randomappsinc.techcareergrowth.home.lessontags

import android.content.Context
import android.graphics.Color
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

    fun getCompletionRateText(): String {
        var numLessonsCompleted = 0.0f
        for (lesson in lessons) {
            if (lesson.isCompleted) {
                numLessonsCompleted += 1.0f
            }
        }
        val completionPercent = ((numLessonsCompleted / (lessons.size.toFloat())) * 100.0f).toInt()
        return "$completionPercent%"
    }

    fun getCompletionTextColor(): Int {
        var numLessonsCompleted = 0.0f
        for (lesson in lessons) {
            if (lesson.isCompleted) {
                numLessonsCompleted += 1.0f
            }
        }
        val completionPercent = numLessonsCompleted / (lessons.size.toFloat())
        val red = (255.0f * (1 - completionPercent)).toInt()
        val green = (255.0f * completionPercent).toInt()
        return Color.rgb(red, green, 0)
    }
}
