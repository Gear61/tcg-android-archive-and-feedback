package com.randomappsinc.techcareergrowth.home.lessontags

import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag

data class LessonTagViewModel(
    val tag: LessonTag,
    val lessons: List<Lesson>,
    val tagLabel: String
)
