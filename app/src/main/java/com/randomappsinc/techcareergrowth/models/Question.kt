package com.randomappsinc.techcareergrowth.models

import android.os.Parcelable
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    @StringRes val textResId: Int,
    @ArrayRes val optionsTextIds: Int,
    @StringRes val correctAnswerId: Int
) : Parcelable
