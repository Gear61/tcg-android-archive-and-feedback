package com.randomappsinc.techcareergrowth.lessonlist

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.common.Constants
import com.randomappsinc.techcareergrowth.contentproviders.LessonProvider
import com.randomappsinc.techcareergrowth.databinding.ActivityMainBinding
import com.randomappsinc.techcareergrowth.databinding.LessonListBinding
import com.randomappsinc.techcareergrowth.home.HomepageAdapter
import com.randomappsinc.techcareergrowth.learning.LessonActivity
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.util.UIUtil

class LessonListActivity: AppCompatActivity(), LessonListAdapter.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LessonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lessonType = intent.getSerializableExtra(Constants.LESSON_TYPE_KEY) as LessonType
        val adapter = LessonListAdapter(
            lessons = LessonProvider.getLessonList(
                type = lessonType,
                context = this
            ),
            listener = this
        )
        binding.lessonList.adapter = adapter
    }

    override fun onLessonClicked(lesson: Lesson) {
        val intent = Intent(this, LessonActivity::class.java)
        intent.putExtra(LessonActivity.LESSON_KEY, lesson)
        startActivityForResult(intent, 1)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
    }
}
