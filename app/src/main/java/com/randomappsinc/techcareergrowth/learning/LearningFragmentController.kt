package com.randomappsinc.techcareergrowth.learning

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

internal class LearningFragmentController(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    private var watchContentFragment: WatchContentFragment? = null
    private var quizFragment: QuizFragment? = null

    fun onStateChange(newState: LearningState) {
        when (newState) {
            LearningState.WATCH_CONTENT -> {
                if (quizFragment != null) {
                    hideFragment(quizFragment!!)
                }
                if (watchContentFragment == null) {
                    watchContentFragment = WatchContentFragment.getInstance()
                    addFragment(watchContentFragment)
                } else {
                    showFragment(watchContentFragment!!)
                }
            }
            LearningState.QUIZ -> {
                if (watchContentFragment != null) {
                    hideFragment(watchContentFragment!!)
                }
                if (quizFragment == null) {
                    quizFragment = QuizFragment.getInstance()
                    addFragment(quizFragment)
                } else {
                    showFragment(quizFragment!!)
                }
            }
            LearningState.SCORE_REPORT -> {
                if (watchContentFragment != null) {
                    hideFragment(watchContentFragment!!)
                }
                if (quizFragment != null) {
                    hideFragment(quizFragment!!)
                }
            }
        }
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
}
