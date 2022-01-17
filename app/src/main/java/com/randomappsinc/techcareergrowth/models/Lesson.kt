package com.randomappsinc.techcareergrowth.models

import androidx.annotation.StringRes

class Lesson(
    val id: String,
    @StringRes val nameResId: Int,
    val youtubeVideoId: String,
    val questions: List<Question>
) {

    fun getYouTubeEmbedUrl(): String {
        return "https://www.youtube.com/embed/$youtubeVideoId"
    }
}
