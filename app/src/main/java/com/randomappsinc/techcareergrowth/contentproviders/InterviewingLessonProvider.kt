package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object InterviewingLessonProvider {

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
                textResId = R.string.interviewing_1_question_1,
                optionsListResId = R.array.interviewing_1_question_1_options,
                correctAnswerId = R.string.interviewing_1_question_1_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_3,
                optionsListResId = R.array.interviewing_1_question_3_options,
                correctAnswerId = R.string.interviewing_1_question_3_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_1_question_5,
                optionsListResId = R.array.interviewing_1_question_5_options,
                correctAnswerId = R.string.interviewing_1_question_5_option_3
            )
        )

        val lessonId = "interviewing_1"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_1_name,
            youtubeVideoId = "j9FD_Y5JTbw",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson2(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_2_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_2_question_2,
                optionsListResId = R.array.interviewing_2_question_2_options,
                correctAnswerId = R.string.interviewing_2_question_2_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_2_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_2_question_4,
                optionsListResId = R.array.interviewing_2_question_4_options,
                correctAnswerId = R.string.interviewing_2_question_4_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_2_question_5,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "interviewing_2"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_2_name,
            youtubeVideoId = "guxFTl_qIRg",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson3(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_3_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_3_question_2,
                optionsListResId = R.array.interviewing_3_question_2_options,
                correctAnswerId = R.string.interviewing_3_question_2_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_3_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_3_question_4,
                optionsListResId = R.array.interviewing_3_question_4_options,
                correctAnswerId = R.string.interviewing_3_question_4_option_2
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_3_question_5,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "interviewing_3"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_3_name,
            youtubeVideoId = "LSLyly2GJo4",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson4(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_4_question_1,
                optionsListResId = R.array.interviewing_4_question_1_options,
                correctAnswerId = R.string.interviewing_4_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_4_question_2,
                optionsListResId = R.array.interviewing_4_question_2_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_4_question_3,
                optionsListResId = R.array.interviewing_4_question_3_options,
                correctAnswerId = R.string.interviewing_4_question_3_option_2
            )
        )

        val lessonId = "interviewing_4"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_4_name,
            youtubeVideoId = "tfqPGGdS8Tk",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson5(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_5_question_1,
                optionsListResId = R.array.interviewing_5_question_1_options,
                correctAnswerId = R.string.interviewing_5_question_1_option_3
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_5_question_2,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_5_question_3,
                optionsListResId = R.array.interviewing_5_question_3_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_5_question_4,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_5_question_5,
                optionsListResId = R.array.interviewing_5_question_5_options,
                correctAnswerId = R.string.interviewing_5_question_5_option_3
            )
        )

        val lessonId = "interviewing_5"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_5_name,
            youtubeVideoId = "TqjiQbyomx4",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }

    private fun getLesson6(context: Context): Lesson {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(
            Question(
                textResId = R.string.interviewing_6_question_1,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_6_question_2,
                optionsListResId = R.array.interviewing_6_question_2_options,
                correctAnswerId = R.string.interviewing_6_question_2_option_4
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_6_question_3,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.true_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_6_question_4,
                optionsListResId = R.array.interviewing_6_question_4_options,
                correctAnswerId = R.string.all_of_the_above
            )
        )
        questions.add(
            Question(
                textResId = R.string.interviewing_6_question_5,
                optionsListResId = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )

        val lessonId = "interviewing_6"
        return Lesson(
            id = lessonId,
            tag = LessonTag.INTERVIEWING,
            nameResId = R.string.interviewing_lesson_6_name,
            youtubeVideoId = "XuOXRBYlidg",
            questions = questions,
            isCompleted = PreferencesManager.getInstance(context).getLessonCompletionStatus(lessonId)
        )
    }
}
