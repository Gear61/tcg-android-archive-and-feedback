package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }

    private var _binding: ScoreReportBinding? = null
    private val binding get() = _binding!!

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
                angle = 270,
                speed = 0f,
                maxSpeed = 175f,
                damping = 0.9f,
                spread = 90,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 5000, TimeUnit.MILLISECONDS).max(1500),
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
