package com.randomappsinc.techcareergrowth

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.joanzapata.iconify.fonts.IoniconsIcons
import com.randomappsinc.techcareergrowth.settings.SettingsActivity
import com.randomappsinc.techcareergrowth.util.UIUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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