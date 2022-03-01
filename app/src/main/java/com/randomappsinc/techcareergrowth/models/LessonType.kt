package com.randomappsinc.techcareergrowth.models

import androidx.annotation.StringRes
import com.randomappsinc.techcareergrowth.R

enum class LessonType(
    @StringRes val overallLabelId: Int,
    @StringRes val orderingLabelId: Int
) {

    INTERVIEWING(
        R.string.interviewing,
        R.string.acing_interviews
    ),
    RESUME(
        R.string.resume,
        R.string.writing_resumes
    ),
    PRODUCTIVITY(
        R.string.productivity,
        R.string.becoming_productive
    ),
    PROMOTION(
        R.string.promotion,
        R.string.getting_promoted
    ),
    LEARNING_QUICKLY(
        R.string.learning_quickly,
        R.string.learning_stuff_quickly
    ),
    MEETINGS(
        R.string.meetings,
        R.string.having_effective_meetings
    )
}
