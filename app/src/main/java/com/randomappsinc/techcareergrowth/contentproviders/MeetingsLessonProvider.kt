package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object MeetingsLessonProvider {

    private var lessons: MutableList<Lesson>? = null

    fun getLessons(context: Context): List<Lesson> {
        if (lessons == null) {
            lessons = mutableListOf()
            lessons!!.add(getLesson1(context = context))
            lessons!!.add(getLesson2(context = context))
        }
        return lessons!!
    }

    private fun getLesson1(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_1_question_1,
                optionsListResId = R.array.meetings_1_question_1_options,
                correctAnswerId = R.string.meetings_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_1_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_1_question_3,
                optionsListResId = R.array.meetings_1_question_3_options,
                correctAnswerId = R.string.meetings_1_question_3_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_1_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_1_question_5,
                optionsListResId = R.array.meetings_question_5_options,
                correctAnswerId = R.string.meetings_1_question_5_option_2
            )
        )

        val lessonId = "meetings_1"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_1_name,
            youtubeVideoId = "e6Ej_9mEc10",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_2_question_1,
                optionsListResId = R.array.meetings_2_question_1_options,
                correctAnswerId = R.string.meetings_2_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_2_question_2,
                optionsListResId = R.array.meetings_2_question_2_options,
                correctAnswerId = R.string.meetings_2_question_2_option_2
            )
        )

        val lessonId = "meetings_2"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_2_name,
            youtubeVideoId = "ZzQquAy7gwQ",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
