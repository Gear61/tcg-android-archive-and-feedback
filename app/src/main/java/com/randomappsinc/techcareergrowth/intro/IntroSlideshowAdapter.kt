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
                imageId = R.drawable.splash_logo,
                titleId = R.string.interviewing_1_question_1_option_2,
                textId = R.string.interviewing_1_question_1
            )
            1 -> IntroSlideshowFragment.getInstance(
                imageId = R.drawable.splash_logo,
                titleId = R.string.interviewing_1_question_1_option_2,
                textId = R.string.interviewing_1_question_1
            )
            2 -> IntroSlideshowFragment.getInstance(
                imageId = R.drawable.splash_logo,
                titleId = R.string.interviewing_1_question_1_option_2,
                textId = R.string.interviewing_1_question_1
            )
            else -> throw IllegalArgumentException("There should only be 3 slides!")
        }
    }
}
