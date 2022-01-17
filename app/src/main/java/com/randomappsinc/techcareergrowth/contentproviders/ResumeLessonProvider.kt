package com.randomappsinc.techcareergrowth.contentproviders

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

object ResumeLessonProvider {

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
                textResId = R.string.resume_1_question_1,
                optionsTextIds = R.array.true_false_options,
                correctAnswerId = R.string.false_option
            )
        )
        questions.add(
            Question(
                textResId = R.string.resume_1_question_2,
                optionsTextIds = R.array.resume_1_question_2_options,
                correctAnswerId = R.string.resume_1_question_2_option_1
            )
        )

        val lessonId = "resume_1"
        return Lesson(
            id = lessonId,
            type = LessonType.RESUME,
            nameResId = R.string.resume_lesson_1_name,
            youtubeVideoId = "MByD2CTwfmM",
            questions = questions,
            isCompleted = PreferencesManager(context).getLessonCompletionStatus(lessonId)
        )
    }
}
