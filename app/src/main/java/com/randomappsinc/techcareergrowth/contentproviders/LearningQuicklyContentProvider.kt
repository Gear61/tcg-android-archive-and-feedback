package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object LearningQuicklyContentProvider {

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
                textResId = R.string.learning_quickly_1_question_1,
                optionsListResId = R.array.learning_quickly_question_1_options,
                correctAnswerId = R.string.learning_quickly_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_1_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_1_question_3,
                optionsListResId = R.array.learning_quickly_1_question_3_options,
                correctAnswerId = R.string.none_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_1_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_1_question_5,
                optionsListResId = R.array.learning_quickly_1_question_5_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "learning_quickly_1"
        return Lesson(
            id = lessonId,
            type = LessonType.LEARNING_QUICKLY,
            nameResId = R.string.learning_quickly_lesson_1_name,
            youtubeVideoId = "fVgZBX0yinc",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.learning_quickly_2_question_1,
                optionsListResId = R.array.learning_quickly_2_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_2_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_2_question_3,
                optionsListResId = R.array.learning_quickly_2_question_3_options,
                correctAnswerId = R.string.learning_quickly_2_question_3_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_2_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.learning_quickly_2_question_5,
                optionsListResId = R.array.learning_quickly_2_question_5_options,
                correctAnswerId = R.string.learning_quickly_2_question_5_option_3
            )
        )

        val lessonId = "learning_quickly_2"
        return Lesson(
            id = lessonId,
            type = LessonType.LEARNING_QUICKLY,
            nameResId = R.string.learning_quickly_lesson_2_name,
            youtubeVideoId = "VS75nql2Csg",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
