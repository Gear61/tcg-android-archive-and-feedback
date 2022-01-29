package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.ScoreReportBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.Rotation
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class ScoreReportFragment: Fragment() {

    companion object {

        fun getInstance(): ScoreReportFragment {
            return ScoreReportFragment()
        }

        const val CONFETTI_ANIMATION_LENGTH_MS = 5000L
        const val NUM_CONFETTI_SHOWN = 1500

        // 1 is constraining them to a straight line, 360 for a full circle
        const val CONFETTI_SPREAD_ANGLE = 90

        // 0 is to the right, making 270 straight up
        const val CONFETTI_TRAVEL_ANGLE = 270
    }

    private var _binding: ScoreReportBinding? = null
    private val binding get() = _binding!!

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
        _binding = ScoreReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as LessonActivity
        binding.lessonTitle.setText(activity.viewState.lesson.nameResId)
        binding.emojiText.setText(activity.viewState.resultEmojiId)
        binding.scoreMessage.text = activity.viewState.scoreMessage
        binding.scoreText.text = activity.viewState.scoreText

        binding.retakeQuizButton.setOnClickListener {
            activity.retakeQuiz()
        }

        binding.relearnContentButton.setOnClickListener {
            activity.relearnContent()
        }

        binding.exitButton.setOnClickListener {
            activity.finish()
        }

        if (activity.viewState.gotPerfectScore) {
            binding.retakeQuizButton.visibility = View.GONE
            binding.relearnContentButton.visibility = View.GONE

            val party = Party(
                angle = CONFETTI_TRAVEL_ANGLE,
                speed = 0f,
                maxSpeed = 175f,
                damping = 0.9f,
                spread = CONFETTI_SPREAD_ANGLE,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = CONFETTI_ANIMATION_LENGTH_MS, TimeUnit.MILLISECONDS).max(NUM_CONFETTI_SHOWN),
                position = Position.Relative(0.5, 1.0),
                rotation = Rotation.enabled()
            )
            binding.konfettiView.visibility = View.VISIBLE
            binding.konfettiView.start(party)
        } else {
            binding.retakeQuizButton.visibility = View.VISIBLE
            binding.relearnContentButton.visibility = View.VISIBLE
        }
    }
}
