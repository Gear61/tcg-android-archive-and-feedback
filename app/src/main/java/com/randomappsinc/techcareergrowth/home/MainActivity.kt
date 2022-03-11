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
import com.randomappsinc.techcareergrowth.databinding.ActivityMainBinding
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.settings.SettingsActivity
import com.randomappsinc.techcareergrowth.util.UIUtil

class MainActivity : AppCompatActivity(), BottomNavigationView.Listener {

    companion object {
        private const val PREVIOUSLY_SELECTED_PAGE_ID = "previouslySelectedPageId"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationController: HomepageFragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencesManager = PreferencesManager.getInstance(this)
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

        navigationController = HomepageFragmentController(supportFragmentManager, R.id.container)
        if (savedInstanceState == null) {
            navigationController.loadHomeInitially()
        } else {
            navigationController.clearFragments()
            val previousSelectedId = savedInstanceState.getInt(
                PREVIOUSLY_SELECTED_PAGE_ID,
                R.id.home
            )
            navigationController.onNavItemSelected(previousSelectedId)
            binding.bottomNavigation.setCurrentlySelected(previousSelectedId)
        }
        binding.bottomNavigation.setListener(this)
    }

    override fun onNavItemSelected(viewId: Int) {
        navigationController.onNavItemSelected(viewId)

        when (viewId) {
            R.id.home -> setTitle(R.string.full_app_name)
            R.id.lesson_tags -> setTitle(R.string.lesson_tags)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(
            PREVIOUSLY_SELECTED_PAGE_ID,
            navigationController.currentViewId
        )
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
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
