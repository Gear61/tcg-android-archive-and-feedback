package com.randomappsinc.techcareergrowth.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.joanzapata.iconify.fonts.IoniconsIcons
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.ActivityMainBinding
import com.randomappsinc.techcareergrowth.settings.SettingsActivity
import com.randomappsinc.techcareergrowth.util.UIUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val profileTabs = resources.getStringArray(R.array.learning_category_options)
        val profileTabsAdapter = LearningCategoryTabsAdapter(
            activity = this,
            numItems = profileTabs.size
        )
        binding.learningCategoryViewpager.adapter = profileTabsAdapter

        TabLayoutMediator(binding.learningCategoryTabs, binding.learningCategoryViewpager) { tab, position ->
            tab.text = profileTabs[position]
        }.attach()
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
