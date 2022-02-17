package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType

object LessonProvider {

    fun getLessonList(type: LessonType, context: Context): List<Lesson> {
        val lessons = when (type) {
            LessonType.INTERVIEWING -> InterviewingLessonProvider.getLessons(context = context)
            LessonType.RESUME -> ResumeLessonProvider.getLessons(context = context)
            LessonType.PRODUCTIVITY -> ProductivityLessonProvider.getLessons(context = context)
            LessonType.PROMOTION -> PromotionLessonProvider.getLessons(context = context)
        }
        verifyLessonList(lessons)
        return lessons
    }

    private fun verifyLessonList(lessons: List<Lesson>) {
        val seenYouTubeIds = mutableSetOf<String>()

        for ((index, lesson) in lessons.iterator().withIndex()) {
            val idPrefix = when (lesson.type) {
                LessonType.INTERVIEWING -> "interviewing"
                LessonType.RESUME -> "resume"
                LessonType.PRODUCTIVITY -> "productivity"
                LessonType.PROMOTION -> "promotion"
            }
            val lessonNumber = (index + 1).toString()
            val expectedLessonId = idPrefix + "_" + lessonNumber
            if (expectedLessonId != lesson.id) {
                error("Lesson ID is incorrect. Expected " + expectedLessonId + " and got " + lesson.id)
            }
            if (seenYouTubeIds.contains(lesson.youtubeVideoId)) {
                error("Duplicate YouTube video ID of " + lesson.youtubeVideoId + " || Lesson ID: " + lesson.id)
            }
            seenYouTubeIds.add(lesson.youtubeVideoId)
        }
    }
}
