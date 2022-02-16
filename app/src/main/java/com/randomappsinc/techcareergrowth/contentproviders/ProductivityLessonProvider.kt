package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object ProductivityLessonProvider {

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
            lessons!!.add(getLesson7(context = context))
            lessons!!.add(getLesson8(context = context))
            lessons!!.add(getLesson9(context = context))
        }
        return lessons!!
    }

    private fun getLesson1(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_1_question_1,
                optionsListResId = R.array.productivity_1_question_1_options,
                correctAnswerId = R.string.productivity_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_1_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_1_question_3,
                optionsListResId = R.array.productivity_1_question_3_options,
                correctAnswerId = R.string.productivity_1_question_3_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_1_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_1_question_5,
                optionsListResId = R.array.productivity_1_question_5_options,
                correctAnswerId = R.string.productivity_1_question_5_option_4
            )
        )

        val lessonId = "productivity_1"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_1_name,
            youtubeVideoId = "XqBA2fkvUTg",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_2_question_1,
                optionsListResId = R.array.productivity_2_question_1_options,
                correctAnswerId = R.string.productivity_2_question_1_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_2_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_2_question_3,
                optionsListResId = R.array.productivity_2_question_3_options,
                correctAnswerId = R.string.productivity_2_question_3_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_2_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_2_question_5,
                optionsListResId = R.array.productivity_2_question_5_options,
                correctAnswerId = R.string.productivity_2_question_5_option_2
            )
        )

        val lessonId = "productivity_2"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_2_name,
            youtubeVideoId = "3gvjpMhhfnY",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson3(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_3_question_1,
                optionsListResId = R.array.productivity_3_question_1_options,
                correctAnswerId = R.string.productivity_3_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_3_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_3_question_3,
                optionsListResId = R.array.productivity_3_question_3_options,
                correctAnswerId = R.string.productivity_3_question_3_option_4
            )
        )

        val lessonId = "productivity_3"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_3_name,
            youtubeVideoId = "7VwKfMZUFxk",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson4(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_4_question_1,
                optionsListResId = R.array.productivity_4_question_1_options,
                correctAnswerId = R.string.productivity_4_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_4_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_4_question_3,
                optionsListResId = R.array.productivity_4_question_3_options,
                correctAnswerId = R.string.productivity_4_question_3_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_4_question_4,
                optionsListResId = R.array.productivity_4_question_4_options,
                correctAnswerId = R.string.productivity_4_question_4_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_4_question_5,
                optionsListResId = R.array.productivity_4_question_5_options,
                correctAnswerId = R.string.productivity_4_question_5_option_1
            )
        )

        val lessonId = "productivity_4"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_4_name,
            youtubeVideoId = "L8a4Sc17DLw",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson5(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_5_question_1,
                optionsListResId = R.array.productivity_5_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_5_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_5_question_3,
                optionsListResId = R.array.productivity_5_question_3_options,
                correctAnswerId = R.string.productivity_5_question_3_option_2
            )
        )

        val lessonId = "productivity_5"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_5_name,
            youtubeVideoId = "Ntb5IvW869s",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson6(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_6_question_1,
                optionsListResId = R.array.productivity_6_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_6_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_6_question_3,
                optionsListResId = R.array.productivity_6_question_3_options,
                correctAnswerId = R.string.productivity_6_question_3_option_1
            )
        )

        val lessonId = "productivity_6"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_6_name,
            youtubeVideoId = "PMUyZ7VoowE",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson7(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_7_question_1,
                optionsListResId = R.array.productivity_7_question_1_options,
                correctAnswerId = R.string.productivity_7_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_7_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_7_question_3,
                optionsListResId = R.array.productivity_7_question_3_options,
                correctAnswerId = R.string.productivity_7_question_3_option_2
            )
        )

        val lessonId = "productivity_7"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_7_name,
            youtubeVideoId = "nrg02T8VSDY",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson8(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_8_question_1,
                optionsListResId = R.array.productivity_8_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_8_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_8_question_3,
                optionsListResId = R.array.productivity_8_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "productivity_8"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_8_name,
            youtubeVideoId = "RPXLB8HH4Q4",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson9(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.productivity_9_question_1,
                optionsListResId = R.array.productivity_9_question_1_options,
                correctAnswerId = R.string.productivity_9_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_9_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.productivity_9_question_3,
                optionsListResId = R.array.productivity_9_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "productivity_9"
        return Lesson(
            id = lessonId,
            type = LessonType.PRODUCTIVITY,
            nameResId = R.string.productivity_lesson_9_name,
            youtubeVideoId = "JtpVI7dc-9A",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
