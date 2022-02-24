package com.randomappsinc.techcareergrowth.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.randomappsinc.techcareergrowth.models.LessonType

class LearningCategoryTabsAdapter(
    activity: FragmentActivity,
    private val lessonTypes: List<LessonType>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = lessonTypes.size

    override fun createFragment(position: Int): Fragment {
        return LessonListFragment.getInstance(lessonType = lessonTypes[position])
    }
}
