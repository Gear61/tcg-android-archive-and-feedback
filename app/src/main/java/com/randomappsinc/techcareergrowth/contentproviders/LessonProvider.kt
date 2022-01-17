package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType

object LessonProvider {

    fun getLessonList(type: LessonType, context: Context): List<Lesson> {
        return when (type) {
            LessonType.INTERVIEWING -> InterviewingLessonProvider.getLessons(context = context)
            LessonType.RESUME -> ResumeLessonProvider.getLessons(context = context)
        }
    }
}
