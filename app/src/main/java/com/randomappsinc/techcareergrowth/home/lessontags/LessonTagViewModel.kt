package com.randomappsinc.techcareergrowth.home.lessontags

import android.content.Context
import android.graphics.Color
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.util.UIUtil

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

    fun getCompletionTextColor(context: Context): Int {
        var numLessonsCompleted = 0.0f
        for (lesson in lessons) {
            if (lesson.isCompleted) {
                numLessonsCompleted += 1.0f
            }
        }
        val completionPercent = numLessonsCompleted / (lessons.size.toFloat())
        return UIUtil.getInBetweenColor(
            context = context,
            startColorResId = R.color.red,
            endColorResId = R.color.green,
            progressTowardsEnd = completionPercent
        )
    }

    fun onLessonCompleted(lessonId: String): Boolean {
        for (lesson in lessons) {
            if (lesson.id == lessonId) {
                lesson.isCompleted = true
                return true
            }
        }
        return false
    }
}
