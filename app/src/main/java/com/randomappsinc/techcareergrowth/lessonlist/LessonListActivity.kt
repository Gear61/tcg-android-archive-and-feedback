package com.randomappsinc.techcareergrowth.lessonlist

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.common.Constants
import com.randomappsinc.techcareergrowth.contentproviders.LessonProvider
import com.randomappsinc.techcareergrowth.databinding.LessonListBinding
import com.randomappsinc.techcareergrowth.learning.LessonActivity
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class LessonListActivity: AppCompatActivity(), LessonListAdapter.Listener, PreferencesManager.Listener {

    private lateinit var lessonsAdapter: LessonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LessonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val lessonType = intent.getSerializableExtra(Constants.LESSON_TYPE_KEY) as LessonTag
        setTitle(lessonType.overallLabelId)

        PreferencesManager.getInstance(this).registerListener(listener = this)
        lessonsAdapter = LessonListAdapter(
            lessons = LessonProvider.getLessonList(
                tag = lessonType,
                context = this
            ),
            listener = this
        )
        binding.lessonList.adapter = lessonsAdapter
    }

    override fun onLessonCompleted(lessonId: String) {
        lessonsAdapter.onLessonCompleted(lessonId = lessonId)
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

    override fun finish() {
        super.finish()
        PreferencesManager.getInstance(this).unregisterListener(listener = this)
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
