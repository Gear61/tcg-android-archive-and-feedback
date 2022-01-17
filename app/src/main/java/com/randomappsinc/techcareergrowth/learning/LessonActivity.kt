package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randomappsinc.techcareergrowth.databinding.LessonBinding
import com.randomappsinc.techcareergrowth.models.Lesson

class LessonActivity: AppCompatActivity() {

    companion object {

        const val LESSON_KEY = "lesson"
    }

    private lateinit var lesson: Lesson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lesson = intent.getParcelableExtra(LESSON_KEY)!!

        setTitle(lesson.type.lessonLabelId)
    }
}