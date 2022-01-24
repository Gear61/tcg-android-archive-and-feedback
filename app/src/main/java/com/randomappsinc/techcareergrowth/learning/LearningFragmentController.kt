package com.randomappsinc.techcareergrowth.learning

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

internal class LearningFragmentController(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) {

    companion object {

        const val WATCH_CONTENT_TAG = "WATCH_CONTENT"
        const val QUIZ_TAG = "QUIZ"
        const val SCORE_REPORT_TAG = "SCORE_REPORT"
    }

    private var currentState: LearningState = LearningState.NONE

    fun onStateChange(newState: LearningState) {
        removeCurrentFragment()
        currentState = newState

        // Swap in new fragment
        when (newState) {
            LearningState.WATCH_CONTENT -> {
                addFragment(WatchContentFragment.getInstance())
            }
            LearningState.QUIZ -> {
                addFragment(QuizFragment.getInstance())
            }
            LearningState.SCORE_REPORT -> {
                addFragment(ScoreReportFragment.getInstance())
            }
            LearningState.NONE -> {}
        }
    }

    private fun addFragment(fragment: Fragment?) {
        fragmentManager
            .beginTransaction()
            .add(containerId, fragment!!, getTagForCurrentState())
            .commit()
    }

    private fun getTagForCurrentState(): String {
        return when (currentState) {
            LearningState.WATCH_CONTENT -> WATCH_CONTENT_TAG
            LearningState.QUIZ -> QUIZ_TAG
            LearningState.SCORE_REPORT -> SCORE_REPORT_TAG
            LearningState.NONE -> error("No fragment tag for NONE state!")
        }
    }

    private fun removeCurrentFragment() {
        if (currentState == LearningState.NONE) {
            return
        }

        val fragmentToRemove = fragmentManager.findFragmentByTag(getTagForCurrentState())
        if (fragmentToRemove != null) {
            fragmentManager.beginTransaction().remove(fragmentToRemove).commit();
        }
    }
}
