package com.randomappsinc.techcareergrowth.models

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

data class Question(
    @StringRes val textResId: Int,
    @ArrayRes val optionsTextIds: Int,
    @StringRes val correctAnswerId: Int
)
