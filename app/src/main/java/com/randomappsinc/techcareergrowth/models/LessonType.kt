package com.randomappsinc.techcareergrowth.models

import androidx.annotation.StringRes
import com.randomappsinc.techcareergrowth.R

enum class LessonType(@StringRes val lessonLabelId: Int) {

    INTERVIEWING(R.string.interviewing),
    RESUME(R.string.resume)
}