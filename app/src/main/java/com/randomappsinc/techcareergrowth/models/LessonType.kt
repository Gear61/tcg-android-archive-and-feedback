package com.randomappsinc.techcareergrowth.models

import androidx.annotation.StringRes
import com.randomappsinc.techcareergrowth.R

enum class LessonType(@StringRes val lessonLabelId: Int) {

    INTERVIEWING(R.string.interviewing),
    RESUME(R.string.resume),
    PRODUCTIVITY(R.string.productivity),
    PROMOTION(R.string.promotion),
    LEARNING_QUICKLY(R.string.learning_quickly)
}
