package com.randomappsinc.techcareergrowth.learning

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.QuizBinding
import com.randomappsinc.techcareergrowth.databinding.WatchContentBinding
import java.util.*


class QuizFragment : Fragment() {

    companion object {

        fun getInstance(): QuizFragment {
            return QuizFragment()
        }
    }

    private var _binding: QuizBinding? = null
    private val binding get() = _binding!!
    private var animationLength: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationLength = resources.getInteger(R.integer.shorter_anim_length).toLong()
        loadCurrentQuestionIntoView()
    }

    private fun loadCurrentQuestionIntoView() {

    }

    private fun animateQuestionOut() {
        binding.submitButton.isEnabled = false
        val problemParent = binding.problemParent
        problemParent
            .animate()
            .translationXBy((-1 * problemParent.width).toFloat())
            .alpha(0f)
            .setDuration(animationLength)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    problemParent.translationX = 0f
                    animationQuestionIn()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }

    private fun animationQuestionIn() {
        val problemParent = binding.problemParent
        problemParent
            .animate()
            .alpha(1f)
            .setDuration(animationLength)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    loadCurrentQuestionIntoView()
                }

                override fun onAnimationEnd(animation: Animator) {
                    binding.submitButton.isEnabled = true
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }
}
