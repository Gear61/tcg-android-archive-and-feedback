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
            lessons!!.add(getLesson3(context = context))
            lessons!!.add(getLesson4(context = context))
            lessons!!.add(getLesson5(context = context))
            lessons!!.add(getLesson6(context = context))
            lessons!!.add(getLesson7(context = context))
            lessons!!.add(getLesson8(context = context))
            lessons!!.add(getLesson9(context = context))
            lessons!!.add(getLesson10(context = context))
            lessons!!.add(getLesson11(context = context))
            lessons!!.add(getLesson12(context = context))
            lessons!!.add(getLesson13(context = context))
            lessons!!.add(getLesson14(context = context))
            lessons!!.add(getLesson15(context = context))
            lessons!!.add(getLesson16(context = context))
            lessons!!.add(getLesson17(context = context))
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
                optionsListResId = R.array.meetings_1_question_5_options,
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

    private fun getLesson3(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_3_question_1,
                optionsListResId = R.array.meetings_3_question_1_options,
                correctAnswerId = R.string.meetings_3_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_3_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_3_question_3,
                optionsListResId = R.array.meetings_3_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "meetings_3"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_3_name,
            youtubeVideoId = "BIcS6glgqyQ",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson4(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_4_question_1,
                optionsListResId = R.array.meetings_4_question_1_options,
                correctAnswerId = R.string.meetings_4_question_1_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_4_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_4_question_3,
                optionsListResId = R.array.meetings_4_question_3_options,
                correctAnswerId = R.string.meetings_4_question_3_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_4_question_4,
                optionsListResId = R.array.meetings_4_question_4_options,
                correctAnswerId = R.string.meetings_4_question_4_option_2
            )
        )

        val lessonId = "meetings_4"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_4_name,
            youtubeVideoId = "b4A4zPu4xMQ",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson5(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_5_question_1,
                optionsListResId = R.array.meetings_5_question_1_options,
                correctAnswerId = R.string.meetings_5_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_5_question_2,
                optionsListResId = R.array.meetings_5_question_2_options,
                correctAnswerId = R.string.meetings_5_question_2_option_3
            )
        )

        val lessonId = "meetings_5"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_5_name,
            youtubeVideoId = "q8RxMZqVYmk",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson6(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_6_question_1,
                optionsListResId = R.array.meetings_6_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_6_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "meetings_6"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_6_name,
            youtubeVideoId = "JmVVa94j04I",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson7(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_7_question_1,
                optionsListResId = R.array.meetings_7_question_1_options,
                correctAnswerId = R.string.meetings_7_question_1_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_7_question_2,
                optionsListResId = R.array.meetings_7_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "meetings_7"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_7_name,
            youtubeVideoId = "Et3Klf_jIhM",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson8(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_8_question_1,
                optionsListResId = R.array.meetings_8_question_1_options,
                correctAnswerId = R.string.meetings_8_question_1_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_8_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_8_question_3,
                optionsListResId = R.array.meetings_8_question_3_options,
                correctAnswerId = R.string.meetings_8_question_3_option_1
            )
        )

        val lessonId = "meetings_8"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_8_name,
            youtubeVideoId = "GJHsNeogthY",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson9(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_9_question_1,
                optionsListResId = R.array.meetings_9_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_9_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_9_question_3,
                optionsListResId = R.array.meetings_9_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "meetings_9"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_9_name,
            youtubeVideoId = "4XFgKxYfrxY",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson10(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_10_question_1,
                optionsListResId = R.array.meetings_10_question_1_options,
                correctAnswerId = R.string.meetings_10_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_10_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "meetings_10"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_10_name,
            youtubeVideoId = "3x4Oz332R9s",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson11(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_11_question_1,
                optionsListResId = R.array.meetings_11_question_1_options,
                correctAnswerId = R.string.meetings_11_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_11_question_2,
                optionsListResId = R.array.meetings_11_question_2_options,
                correctAnswerId = R.string.meetings_11_question_2_option_2
            )
        )

        val lessonId = "meetings_11"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_11_name,
            youtubeVideoId = "bPk5gEoGLAU",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson12(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_12_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_12_question_2,
                optionsListResId = R.array.meetings_12_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "meetings_12"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_12_name,
            youtubeVideoId = "NswneqhmEJ4",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson13(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_13_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_13_question_2,
                optionsListResId = R.array.meetings_13_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_13_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_13_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "meetings_13"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_13_name,
            youtubeVideoId = "Ftcwz1I6mIg",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson14(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_14_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_14_question_2,
                optionsListResId = R.array.meetings_14_question_2_options,
                correctAnswerId = R.string.meetings_14_question_2_option_2
            )
        )

        val lessonId = "meetings_14"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_14_name,
            youtubeVideoId = "X8nxyvydHjg",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson15(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_15_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_15_question_2,
                optionsListResId = R.array.meetings_15_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_15_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "meetings_15"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_15_name,
            youtubeVideoId = "SBf9S0B0W3Q",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson16(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_16_question_1,
                optionsListResId = R.array.meetings_16_question_1_options,
                correctAnswerId = R.string.meetings_16_question_1_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_16_question_2,
                optionsListResId = R.array.meetings_16_question_2_options,
                correctAnswerId = R.string.meetings_16_question_2_option_1
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_16_question_3,
                optionsListResId = R.array.meetings_16_question_3_options,
                correctAnswerId = R.string.meetings_16_question_3_option_1
            )
        )

        val lessonId = "meetings_16"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_16_name,
            youtubeVideoId = "7ZM7YNKHLy8",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson17(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.meetings_17_question_1,
                optionsListResId = R.array.meetings_17_question_1_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_17_question_2,
                optionsListResId = R.array.yes_no_options,
                correctAnswerId = R.string.no
            )
        )
        questions.add(
            Question(
                textResId = R.string.meetings_17_question_3,
                optionsListResId = R.array.meetings_17_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )

        val lessonId = "meetings_17"
        return Lesson(
            id = lessonId,
            type = LessonType.MEETINGS,
            nameResId = R.string.meetings_lesson_17_name,
            youtubeVideoId = "qWXfT2fiPVE",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
