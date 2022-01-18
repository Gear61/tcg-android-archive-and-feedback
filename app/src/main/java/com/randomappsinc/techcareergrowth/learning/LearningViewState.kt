package com.randomappsinc.techcareergrowth.learning

import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.Question

class LearningViewState(
    val lesson: Lesson,
    var currentQuestionIndex: Int = 0,
    val questionAnswers: MutableList<String> = mutableListOf()
) {

    fun getCurrentQuestion(): Question {
        return lesson.questions[currentQuestionIndex]
    }

    fun submitAnswer(answer: String) {
        questionAnswers.add(answer)
        currentQuestionIndex++
    }
}
