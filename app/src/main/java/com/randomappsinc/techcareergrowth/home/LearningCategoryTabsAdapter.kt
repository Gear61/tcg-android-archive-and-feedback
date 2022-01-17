package com.randomappsinc.techcareergrowth.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.randomappsinc.techcareergrowth.models.LessonType

class LearningCategoryTabsAdapter(
    activity: FragmentActivity,
    private val numItems: Int
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = numItems

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LessonListFragment.getInstance(LessonType.INTERVIEWING)
            1 -> LessonListFragment.getInstance(LessonType.RESUME)
            else -> throw IllegalArgumentException("There should only be 2 tabs!")
        }
    }
}
