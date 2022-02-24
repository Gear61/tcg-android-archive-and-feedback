package com.randomappsinc.techcareergrowth.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.randomappsinc.techcareergrowth.databinding.IntroSlideshowFragmentBinding

class IntroSlideshowFragment : Fragment() {

    companion object {

        private const val LOTTIE_RES_ID_KEY = "lottieResId"
        private const val TITLE_ID_KEY = "titleId"
        private const val TEXT_ID_KEY = "textId"

        fun getInstance(
            @RawRes lottieResId: Int,
            @StringRes titleId: Int,
            @StringRes textId: Int
        ): IntroSlideshowFragment {
            val bundle = Bundle()
            bundle.putInt(LOTTIE_RES_ID_KEY, lottieResId)
            bundle.putInt(TITLE_ID_KEY, titleId)
            bundle.putInt(TEXT_ID_KEY, textId)
            val fragment = IntroSlideshowFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: IntroSlideshowFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var slideAnimation: LottieAnimationView
    private lateinit var slideTitle: TextView
    private lateinit var slideText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = IntroSlideshowFragmentBinding.inflate(inflater, container, false)
        slideAnimation = binding.slideAnimation
        slideTitle = binding.slideTitle
        slideText = binding.slideText
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slideAnimation.setAnimation(requireArguments().getInt(LOTTIE_RES_ID_KEY))
        slideTitle.setText(requireArguments().getInt(TITLE_ID_KEY))
        slideText.setText(requireArguments().getInt(TEXT_ID_KEY))
    }
}
