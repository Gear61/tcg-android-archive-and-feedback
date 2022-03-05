package com.randomappsinc.techcareergrowth.models

import androidx.annotation.StringRes
import com.randomappsinc.techcareergrowth.R

enum class LessonTag(
    @StringRes val overallLabelId: Int
) {

    INTERVIEWING(R.string.interviewing),
    DSA(R.string.dsa),
    BIG_TECH(R.string.big_tech),
    RESUME(R.string.resume),
    PRODUCTIVITY(R.string.productivity),
    PROMOTION(R.string.promotion),
    LEARNING_QUICKLY(R.string.learning_quickly),
    MEETINGS(R.string.meetings),
    ONE_ON_ONE_MEETINGS(R.string.one_on_one_meetings),
    WORKING_WITH_MANAGER(R.string.working_with_manager),
    JUNIOR_ENGINEER(R.string.junior_engineer),
    SENIOR_ENGINEER(R.string.senior_engineer)
}
