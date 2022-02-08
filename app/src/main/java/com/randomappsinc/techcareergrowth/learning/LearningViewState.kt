package com.randomappsinc.techcareergrowth.learning

import android.content.Context
import androidx.annotation.StringRes
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.Question
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class LearningViewState(
    val listener: Listener,
    val lesson: Lesson,
    var currentQuestionIndex: Int = 0,
    var scoreMessage: String = "",
    var scoreText: String = "",
    var gotPerfectScore: Boolean = false,
    var completedForFirstTime: Boolean = false,
    @StringRes var resultEmojiId: Int = R.string.sad_emoji,
    private val questionAnswers: MutableList<String> = mutableListOf()
) {

    interface Listener {
        fun onQuizComplete()
    }

    fun getQuestionNumberText(context: Context): String {
        val firstNumber = (currentQuestionIndex + 1).toString()
        val totalNumber = lesson.questions.size.toString()
        return context.getString(R.string.question_header, firstNumber, totalNumber)
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
            if (percentCorrect == 100.0f) {
                gotPerfectScore = true
                if (!lesson.isCompleted) {
                    completedForFirstTime = true
                    PreferencesManager(context).onLessonCompleted(lesson.id)
                }
            }
            if (percentCorrect == 100.0f) {
                scoreMessage = context.getString(R.string.perfect_score_message)
                resultEmojiId = R.string.party_emoji
            } else if (percentCorrect >= 80.0f) {
                scoreMessage = context.getString(R.string.b_grade_message)
                resultEmojiId = R.string.slight_smile_emoji
            } else {
                scoreMessage = context.getString(R.string.c_grade_message)
                resultEmojiId = R.string.sad_emoji
            }

            val fractionText = numCorrect.toString() + "/" + questionAnswers.size.toString()
            val percentText = String.format("%.2f", percentCorrect) + "%"
            scoreText = context.getString(R.string.score_text_template, fractionText, percentText)

            listener.onQuizComplete()
        } else {
            currentQuestionIndex++
        }
    }

    fun resetQuiz() {
        questionAnswers.clear()
        currentQuestionIndex = 0
    }
}
