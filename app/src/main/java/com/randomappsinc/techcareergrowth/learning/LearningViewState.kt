package com.randomappsinc.techcareergrowth.learning

import android.content.Context
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.Question

class LearningViewState(
    val listener: Listener,
    val lesson: Lesson,
    var currentQuestionIndex: Int = 0,
    var scoreMessage: String = "",
    var scoreText: String = "",
    private val questionAnswers: MutableList<String> = mutableListOf()
) {

    interface Listener {
        fun onQuizComplete()
    }

    fun getCurrentQuestion(): Question {
        return lesson.questions[currentQuestionIndex]
    }

    fun submitAnswer(answer: String, context: Context) {
        questionAnswers.add(answer)
        if (questionAnswers.size == lesson.questions.size) {
            var numCorrect = 0
            for ((index, submittedAnswer) in questionAnswers.withIndex()) {
                val rightAnswer = context.getString(lesson.questions[index].correctAnswerId)
                if (submittedAnswer == rightAnswer) {
                    numCorrect++
                }
            }
            val percentCorrect = (numCorrect.toFloat() / questionAnswers.size.toFloat()) * 100.0f
            scoreMessage = if (percentCorrect == 100.0f) {
                context.getString(R.string.perfect_score_message)
            } else if (percentCorrect >= 80.0f) {
                context.getString(R.string.b_grade_message)
            } else {
                context.getString(R.string.c_grade_message)
            }
            listener.onQuizComplete()
        } else {
            currentQuestionIndex++
        }
    }

    fun retakeQuiz() {
        questionAnswers.clear()
        currentQuestionIndex = 0
    }
}
