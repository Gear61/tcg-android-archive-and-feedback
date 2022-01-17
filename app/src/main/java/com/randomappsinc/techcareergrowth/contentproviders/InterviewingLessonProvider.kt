package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object InterviewingLessonProvider {

    private var lessons: MutableList<Lesson>? = null

    fun getLessons(context: Context): List<Lesson> {
        if (lessons == null) {
            lessons = mutableListOf()
            lessons!!.add(getLesson1(context = context))
        }
        return lessons!!
    }

    private fun getLesson1(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_1,
                optionsTextIds = R.array.interviewing_1_question_1_options,
                correctAnswerId = R.string.interviewing_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_2,
                optionsTextIds = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_3,
                optionsTextIds = R.array.interviewing_1_question_3_options,
                correctAnswerId = R.string.interviewing_1_question_3_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_4,
                optionsTextIds = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_5,
                optionsTextIds = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "interviewing_1"
        return Lesson(
            id = lessonId,
            nameResId = R.string.interviewing_lesson_1_name,
            youtubeVideoId = "j9FD_Y5JTbw",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
