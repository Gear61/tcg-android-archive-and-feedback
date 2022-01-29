package com.randomappsinc.techcareergrowth.learning

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.QuizBinding
import com.randomappsinc.techcareergrowth.util.UIUtil

class QuizFragment : Fragment() {

    companion object {

        fun getInstance(): QuizFragment {
            return QuizFragment()
        }
    }

    private var _binding: QuizBinding? = null
    private val binding get() = _binding!!
    private var animationLength: Long = 0
    private var viewState: LearningViewState? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.fade)
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

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

        val activity = requireActivity() as LessonActivity
        viewState = activity.viewState
        loadCurrentQuestionIntoView()

        binding.submitButton.setOnClickListener {
            val checkedButton = binding.questionOptions.checkedButton
            if (checkedButton == null) {
                UIUtil.showLongToast(R.string.no_option_selected, requireContext())
                return@setOnClickListener
            }
            viewState!!.submitAnswer(
                answer = checkedButton.text,
                context = requireContext()
            )
            animateQuestionOut()
        }
    }

    fun loadCurrentQuestionIntoView() {
        if (!isAdded || viewState == null) {
            return
        }

        val radioGroup = binding.questionOptions
        val question = viewState!!.getCurrentQuestion()

        binding.questionText.setText(question.textResId)
        val options = resources.getStringArray(question.optionsListResId)
        radioGroup.setSize(options.size)
        for ((index, option) in options.withIndex()) {
            val radioButton = radioGroup.getRadioButton(index)
            radioButton.text = option
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        viewState = null
    }
}
