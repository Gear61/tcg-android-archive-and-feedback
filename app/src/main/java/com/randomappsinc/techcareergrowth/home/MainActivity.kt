package com.randomappsinc.techcareergrowth.home

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.joanzapata.iconify.fonts.IoniconsIcons
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.common.Constants
import com.randomappsinc.techcareergrowth.databinding.ActivityMainBinding
import com.randomappsinc.techcareergrowth.learning.LessonActivity
import com.randomappsinc.techcareergrowth.lessonlist.LessonListActivity
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonType
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.settings.SettingsActivity
import com.randomappsinc.techcareergrowth.util.ListUtil
import com.randomappsinc.techcareergrowth.util.UIUtil

class MainActivity : AppCompatActivity(), HomepageAdapter.Listener, PreferencesManager.Listener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var homepageAdapter: HomepageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencesManager = PreferencesManager.getInstance(this)
        preferencesManager.registerListener(listener = this)
        if (preferencesManager.logAppOpenAndCheckForRatingUpsell()) {
            AlertDialog.Builder(this)
                .setMessage(R.string.please_rate)
                .setNegativeButton(R.string.no_im_good) { _: DialogInterface, _: Int -> }
                .setPositiveButton(R.string.will_rate) { _: DialogInterface, _: Int ->
                    val uri = Uri.parse("market://details?id=$packageName")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    if (packageManager.queryIntentActivities(intent, 0).size <= 0) {
                        UIUtil.showLongToast(R.string.play_store_error, this)
                        return@setPositiveButton
                    }
                    startActivity(intent)
                }
                .show()
        }

        val lessonTypes = preferencesManager.getContentOrder()
        homepageAdapter = HomepageAdapter(
            lessonTypes = lessonTypes,
            listener = this
        )
        binding.homepageList.adapter = homepageAdapter
    }

    override fun onLessonCompleted(lessonId: String) {
        homepageAdapter.onLessonCompleted(lessonId = lessonId)
    }

    override fun onResume() {
        super.onResume()
        val freshLessonTypes = preferencesManager.getContentOrder()
        if (!ListUtil.areListsEqual(first = freshLessonTypes, second = homepageAdapter.lessonTypes)) {
            homepageAdapter.clear()
            homepageAdapter = HomepageAdapter(
                lessonTypes = freshLessonTypes,
                listener = this
            )
            binding.homepageList.adapter = homepageAdapter
        }
    }

    override fun onLessonClicked(lesson: Lesson) {
        val intent = Intent(this, LessonActivity::class.java)
        intent.putExtra(LessonActivity.LESSON_KEY, lesson)
        startActivity(intent)
    }

    override fun onLessonTypeClicked(type: LessonType) {
        val intent = Intent(this, LessonListActivity::class.java)
        intent.putExtra(Constants.LESSON_TYPE_KEY, type)
        startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
    }

    override fun finish() {
        super.finish()
        preferencesManager.unregisterListener(listener = this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        UIUtil.loadMenuIcon(
            menu!!,
            R.id.settings,
            IoniconsIcons.ion_android_settings,
            this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                val loginIntent = Intent(this, SettingsActivity::class.java)
                startActivity(loginIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
