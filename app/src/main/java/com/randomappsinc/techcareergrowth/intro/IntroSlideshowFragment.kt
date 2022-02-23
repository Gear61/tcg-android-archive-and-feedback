package com.randomappsinc.techcareergrowth.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.databinding.IntroSlideshowFragmentBinding

class IntroSlideshowFragment : Fragment() {

    companion object {

        private const val IMAGE_ID_KEY = "imageId"
        private const val TITLE_ID_KEY = "titleId"
        private const val TEXT_ID_KEY = "textId"

        fun getInstance(
            @DrawableRes imageId: Int,
            @StringRes titleId: Int,
            @StringRes textId: Int
        ): IntroSlideshowFragment {
            val bundle = Bundle()
            bundle.putInt(IMAGE_ID_KEY, imageId)
            bundle.putInt(TITLE_ID_KEY, titleId)
            bundle.putInt(TEXT_ID_KEY, textId)
            val fragment = IntroSlideshowFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: IntroSlideshowFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var slideImage: ImageView
    private lateinit var slideTitle: TextView
    private lateinit var slideText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = IntroSlideshowFragmentBinding.inflate(inflater, container, false)
        slideImage = binding.slideImage
        slideTitle = binding.slideTitle
        slideText = binding.slideText
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slideImage.setImageResource(requireArguments().getInt(IMAGE_ID_KEY))
        slideTitle.setText(requireArguments().getInt(TITLE_ID_KEY))
        slideText.setText(requireArguments().getInt(TEXT_ID_KEY))
    }
}
