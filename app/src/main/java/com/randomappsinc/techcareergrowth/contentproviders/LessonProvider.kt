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
            LessonType.LEARNING_QUICKLY -> LearningQuicklyContentProvider.getLessons(context = context)
            LessonType.MEETINGS -> MeetingsLessonProvider.getLessons(context = context)
        }
        verifyLessonList(
            lessons = lessons,
            context = context
        )

        val incompleteLessons = mutableListOf<Lesson>()
        val completedLessons = mutableListOf<Lesson>()
        for (lesson in lessons) {
            if (lesson.isCompleted) {
                completedLessons.add(lesson)
            } else {
                incompleteLessons.add(lesson)
            }
        }

        return incompleteLessons + completedLessons
    }

    private fun verifyLessonList(lessons: List<Lesson>, context: Context) {
        val seenYouTubeIds = mutableSetOf<String>()

        for ((index, lesson) in lessons.iterator().withIndex()) {
            val idPrefix = when (lesson.type) {
                LessonType.INTERVIEWING -> "interviewing"
                LessonType.RESUME -> "resume"
                LessonType.PRODUCTIVITY -> "productivity"
                LessonType.PROMOTION -> "promotion"
                LessonType.LEARNING_QUICKLY -> "learning_quickly"
                LessonType.MEETINGS -> "meetings"
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

            for (question in lesson.questions) {
                val options = context.resources.getStringArray(question.optionsListResId)
                val rightAnswer = context.getString(question.correctAnswerId)
                if (rightAnswer !in options) {
                    val questionText = context.getString(question.textResId)
                    error("There is no correct answer for the question [" + questionText + "] || Lesson ID: " + lesson.id)
                }
            }
        }
    }
}
