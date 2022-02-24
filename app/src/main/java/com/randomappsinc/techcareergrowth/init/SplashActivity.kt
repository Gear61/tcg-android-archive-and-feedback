package com.randomappsinc.techcareergrowth.init

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.randomappsinc.techcareergrowth.home.MainActivity
import com.randomappsinc.techcareergrowth.intro.IntroSlideshowActivity
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kill activity if it's above an existing stack due to launcher bug
        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null && intent.action == Intent.ACTION_MAIN) {
            finish()
            return
        }

        if (PreferencesManager(this).hasSeenSlideshow) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, IntroSlideshowActivity::class.java))
        }
        finish()
    }
}
