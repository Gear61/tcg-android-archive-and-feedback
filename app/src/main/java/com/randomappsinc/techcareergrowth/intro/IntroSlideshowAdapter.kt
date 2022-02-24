package com.randomappsinc.techcareergrowth.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.randomappsinc.techcareergrowth.R

class IntroSlideshowAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IntroSlideshowFragment.getInstance(
                lottieResId = R.raw.welcome,
                titleId = R.string.welcome_title,
                textId = R.string.welcome_text
            )
            1 -> IntroSlideshowFragment.getInstance(
                lottieResId = R.raw.learn,
                titleId = R.string.learn_title,
                textId = R.string.learn_text
            )
            2 -> IntroSlideshowFragment.getInstance(
                lottieResId = R.raw.feedback,
                titleId = R.string.feedback_title,
                textId = R.string.feedback_text
            )
            else -> throw IllegalArgumentException("There should only be 3 slides!")
        }
    }
}
