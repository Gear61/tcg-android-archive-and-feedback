package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.LessonPageBinding
import com.randomappsinc.techcareergrowth.models.Lesson

class LessonActivity: AppCompatActivity(), LearningViewState.Listener {

    companion object {

        const val LESSON_KEY = "lesson"
    }

    lateinit var lesson: Lesson
    lateinit var viewState: LearningViewState
    private lateinit var fragmentController: LearningFragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LessonPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        lesson = intent.getParcelableExtra(LESSON_KEY)!!

        viewState = LearningViewState(
            listener = this,
            lesson = lesson
        )

        fragmentController = LearningFragmentController(
            fragmentManager = supportFragmentManager,
            containerId = R.id.container
        )
        fragmentController.onStateChange(newState = LearningState.WATCH_CONTENT)
    }

    fun takeQuiz() {
        fragmentController.onStateChange(LearningState.QUIZ)
    }

    fun retakeQuiz() {
        viewState.resetQuiz()
        fragmentController.onStateChange(LearningState.QUIZ)
    }

    fun relearnContent() {
        viewState.resetQuiz()
        fragmentController.onStateChange(LearningState.WATCH_CONTENT)
    }

    override fun onQuizComplete() {
        fragmentController.onStateChange(LearningState.SCORE_REPORT)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
