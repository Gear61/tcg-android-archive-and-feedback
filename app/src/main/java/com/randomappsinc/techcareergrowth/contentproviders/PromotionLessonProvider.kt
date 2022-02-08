package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object PromotionLessonProvider {

    private var lessons: MutableList<Lesson>? = null

    fun getLessons(context: Context): List<Lesson> {
        if (lessons == null) {
            lessons = mutableListOf()
            lessons!!.add(getLesson1(context = context))
            lessons!!.add(getLesson2(context = context))
            lessons!!.add(getLesson3(context = context))
        }
        return lessons!!
    }

    private fun getLesson1(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.resume_1_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_1_question_2,
                optionsListResId = R.array.resume_1_question_2_options,
                correctAnswerId = R.string.resume_1_question_2_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_1_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_1_question_4,
                optionsListResId = R.array.resume_1_question_4_options,
                correctAnswerId = R.string.resume_1_question_4_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_1_question_5,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "promotion_1"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.resume_lesson_1_name,
            youtubeVideoId = "8a-ZMCGg4rc",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.resume_2_question_1,
                optionsListResId = R.array.yes_no_options,
                correctAnswerId = R.string.no
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_2_question_2,
                optionsListResId = R.array.resume_2_question_2_options,
                correctAnswerId = R.string.resume_2_question_2_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_2_question_3,
                optionsListResId = R.array.yes_no_options,
                correctAnswerId = R.string.yes
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_2_question_4,
                optionsListResId = R.array.resume_2_question_4_options,
                correctAnswerId = R.string.resume_2_question_4_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_2_question_5,
                optionsListResId = R.array.yes_no_options,
                correctAnswerId = R.string.no
            )
        )

        val lessonId = "promotion_2"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.resume_lesson_2_name,
            youtubeVideoId = "sDbK84GEE94",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson3(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.resume_3_question_1,
                optionsListResId = R.array.resume_3_question_1_options,
                correctAnswerId = R.string.resume_3_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_3_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_3_question_3,
                optionsListResId = R.array.resume_3_question_3_options,
                correctAnswerId = R.string.resume_3_question_3_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_3_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )

        val lessonId = "promotion_3"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.resume_lesson_3_name,
            youtubeVideoId = "9Wb-gHEO9ug",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}