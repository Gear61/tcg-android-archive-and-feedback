package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag

object LessonProvider {

    private var lessons: List<Lesson>? = null

    fun getLessonList(tag: LessonTag, context: Context): List<Lesson> {
        if (lessons == null) {
            lessons = listOf(
                InterviewingLessonProvider.getLessons(context = context),
                ResumeLessonProvider.getLessons(context = context),
                ProductivityLessonProvider.getLessons(context = context),
                PromotionLessonProvider.getLessons(context = context),
                LearningQuicklyContentProvider.getLessons(context = context),
                MeetingsLessonProvider.getLessons(context = context)
            ).flatten()
            verifyLessonList(
                lessons = lessons!!,
                context = context
            )
        }

        val incompleteLessons = mutableListOf<Lesson>()
        val completedLessons = mutableListOf<Lesson>()
        for (lesson in lessons!!) {
            if (lesson.tags.contains(tag)) {
                if (lesson.isCompleted) {
                    completedLessons.add(lesson)
                } else {
                    incompleteLessons.add(lesson)
                }
            }
        }

        return incompleteLessons + completedLessons
    }

    private fun verifyLessonList(lessons: List<Lesson>, context: Context) {
        val seenYouTubeIds = mutableSetOf<String>()
        val seenLessonIds = mutableSetOf<String>()

        for (lesson in lessons) {
            if (seenLessonIds.contains(lesson.id)) {
                error("Duplicate lesson ID of " + lesson.id)
            }
            seenLessonIds.add(lesson.id)
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
