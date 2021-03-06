package com.randomappsinc.techcareergrowth.models

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class Lesson(
    val id: String,
    val tags: Set<LessonTag>,
    @StringRes val nameResId: Int,
    val youtubeVideoId: String,
    val questions: List<Question>,
    var isCompleted: Boolean
): Parcelable {

    fun getYouTubeEmbedUrl(): String {
        return "https://www.youtube.com/embed/$youtubeVideoId"
    }

    fun getYouTubeThumbnailUrl(): String {
        return "https://img.youtube.com/vi/$youtubeVideoId/maxresdefault.jpg"
    }
}
