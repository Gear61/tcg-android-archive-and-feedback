package com.randomappsinc.techcareergrowth.contentproviders

import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType

object LessonProvider {

    fun getLessonList(type: LessonType): List<Lesson> {
        return when (type) {
            LessonType.INTERVIEWING -> InterviewingLessonProvider.lessons
            LessonType.RESUME -> ResumeLessonProvider.lessons
        }
    }
}
