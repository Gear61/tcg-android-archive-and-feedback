package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.databinding.ScoreReportBinding

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

        }

        binding.relearnContentButton.setOnClickListener {

        }

        binding.exitButton.setOnClickListener {

        }

        if (activity.viewState.gotPerfectScore) {
            binding.retakeQuizButton.visibility = View.GONE
            binding.relearnContentButton.visibility = View.GONE
        } else {
            binding.retakeQuizButton.visibility = View.VISIBLE
            binding.relearnContentButton.visibility = View.VISIBLE
        }
    }
}
