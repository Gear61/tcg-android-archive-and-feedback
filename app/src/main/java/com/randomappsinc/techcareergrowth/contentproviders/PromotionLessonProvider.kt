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
            lessons!!.add(getLesson4(context = context))
            lessons!!.add(getLesson5(context = context))
            lessons!!.add(getLesson6(context = context))
        }
        return lessons!!
    }

    private fun getLesson1(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_1_question_1,
                optionsListResId = R.array.promotion_1_question_1_options,
                correctAnswerId = R.string.promotion_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_1_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_1_question_3,
                optionsListResId = R.array.promotion_1_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "promotion_1"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_1_name,
            youtubeVideoId = "8a-ZMCGg4rc",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_2_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_2_question_2,
                optionsListResId = R.array.promotion_2_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_2_question_3,
                optionsListResId = R.array.promotion_2_question_3_options,
                correctAnswerId = R.string.promotion_2_question_3_option_3
            )
        )

        val lessonId = "promotion_2"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_2_name,
            youtubeVideoId = "tdfXpFZriFI",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson3(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_3_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_3_question_2,
                optionsListResId = R.array.promotion_3_question_2_options,
                correctAnswerId = R.string.promotion_3_question_2_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_3_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_3_question_4,
                optionsListResId = R.array.promotion_3_question_4_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_3_question_5,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )

        val lessonId = "promotion_3"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_3_name,
            youtubeVideoId = "wgCDDE_WAJ8",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson4(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_4_question_1,
                optionsListResId = R.array.promotion_4_question_1_options,
                correctAnswerId = R.string.promotion_4_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_4_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_4_question_3,
                optionsListResId = R.array.promotion_4_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "promotion_4"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_4_name,
            youtubeVideoId = "6ss9oQWn2K8",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson5(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_1,
                optionsListResId = R.array.promotion_5_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_2,
                optionsListResId = R.array.promotion_5_question_2_options,
                correctAnswerId = R.string.promotion_5_question_2_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_3,
                optionsListResId = R.array.promotion_5_question_3_options,
                correctAnswerId = R.string.promotion_5_question_3_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_4,
                optionsListResId = R.array.value_options,
                correctAnswerId = R.string.multiplicative_value
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_5,
                optionsListResId = R.array.value_options,
                correctAnswerId = R.string.additive_value
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_6,
                optionsListResId = R.array.value_options,
                correctAnswerId = R.string.multiplicative_value
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_5_question_7,
                optionsListResId = R.array.value_options,
                correctAnswerId = R.string.additive_value
            )
        )

        val lessonId = "promotion_5"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_5_name,
            youtubeVideoId = "nHwHnNwN6to",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson6(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.promotion_6_question_1,
                optionsListResId = R.array.promotion_6_question_1_options,
                correctAnswerId = R.string.promotion_6_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_6_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.promotion_6_question_3,
                optionsListResId = R.array.promotion_6_question_3_options,
                correctAnswerId = R.string.promotion_6_question_3_option_1
            )
        )

        val lessonId = "promotion_6"
        return Lesson(
            id = lessonId,
            type = LessonType.PROMOTION,
            nameResId = R.string.promotion_lesson_6_name,
            youtubeVideoId = "xDKjrf-tpZ4",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}