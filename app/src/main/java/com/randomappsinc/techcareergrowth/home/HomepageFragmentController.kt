package com.randomappsinc.techcareergrowth.home

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.home.lessontags.LessonTagsFragment
import com.randomappsinc.techcareergrowth.home.mainfeed.HomeFeedFragment

internal class HomepageFragmentController(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {
    private var homeFeedFragment: HomeFeedFragment? = null
    private var lessonTagsFragment: LessonTagsFragment? = null

    @IdRes
    var currentViewId = 0

    fun onNavItemSelected(@IdRes viewId: Int) {
        if (currentViewId == viewId) {
            return
        }
        when (currentViewId) {
            R.id.home -> hideFragment(homeFeedFragment!!)
            R.id.lesson_tags -> hideFragment(lessonTagsFragment!!)
        }
        currentViewId = viewId
        when (viewId) {
            R.id.home -> if (homeFeedFragment == null) {
                homeFeedFragment = HomeFeedFragment.getInstance()
                addFragment(homeFeedFragment)
            } else {
                showFragment(homeFeedFragment!!)
            }
            R.id.lesson_tags -> if (lessonTagsFragment == null) {
                lessonTagsFragment = LessonTagsFragment.getInstance()
                addFragment(lessonTagsFragment)
            } else {
                showFragment(lessonTagsFragment!!)
            }
        }
    }

    /** Called by the app upon start up to load the homepage  */
    fun loadHomeInitially() {
        onNavItemSelected(R.id.home)
    }

    private fun addFragment(fragment: Fragment?) {
        fragmentManager.beginTransaction().add(containerId, fragment!!).commit()
    }

    private fun showFragment(fragment: Fragment) {
        fragmentManager.beginTransaction().show(fragment).commit()
    }

    private fun hideFragment(fragment: Fragment) {
        fragmentManager.beginTransaction().hide(fragment).commit()
    }

    fun restoreFragments() {
        for (fragment in fragmentManager.fragments) {
            val fragmentName = fragment.javaClass.simpleName
            if (HomeFeedFragment::class.java.simpleName.equals(fragmentName)) {
                homeFeedFragment = fragment as HomeFeedFragment
            } else if (LessonTagsFragment::class.java.simpleName.equals(fragmentName)) {
                lessonTagsFragment = fragment as LessonTagsFragment
            }
        }
    }
}
