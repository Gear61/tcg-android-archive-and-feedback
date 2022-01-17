package com.randomappsinc.techcareergrowth.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.randomappsinc.techcareergrowth.learning.LessonFragment

class LearningCategoryTabsAdapter(
    activity: FragmentActivity,
    private val numItems: Int
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = numItems

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LessonFragment.getInstance()
            1 -> LessonFragment.getInstance()
            else -> throw IllegalArgumentException("There should only be 2 tabs!")
        }
    }
}
