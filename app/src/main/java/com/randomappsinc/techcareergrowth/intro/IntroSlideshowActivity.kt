package com.randomappsinc.techcareergrowth.intro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.IntroSlideshowActivityBinding
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.settings.OrderContentActivity

class IntroSlideshowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = IntroSlideshowActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencesManager = PreferencesManager.getInstance(this)

        binding.slideshowViewpager.adapter = IntroSlideshowAdapter(this)
        binding.slideshowViewpager.offscreenPageLimit = 3
        binding.slideshowViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.circleOne.setImageResource(R.drawable.filled_green_circle_background)
                        binding.circleTwo.setImageResource(R.drawable.indicator_circle)
                        binding.circleThree.setImageResource(R.drawable.indicator_circle)
                    }
                    1 -> {
                        binding.circleTwo.setImageResource(R.drawable.filled_green_circle_background)
                        binding.circleOne.setImageResource(R.drawable.indicator_circle)
                        binding.circleThree.setImageResource(R.drawable.indicator_circle)
                    }
                    2 -> {
                        preferencesManager.hasSeenSlideshow = true
                        binding.circleThree.setImageResource(R.drawable.filled_green_circle_background)
                        binding.circleTwo.setImageResource(R.drawable.indicator_circle)
                        binding.circleOne.setImageResource(R.drawable.indicator_circle)
                    }
                }
            }
        })
        binding.slideshowViewpager.currentItem = 0
        binding.getStartedButton.setOnClickListener {
            preferencesManager.hasSeenSlideshow = true
            val intent = Intent(this, OrderContentActivity::class.java)
            intent.putExtra(OrderContentActivity.FROM_SETTINGS_KEY, false)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.stay)
            finish()
        }
    }
}
