package com.randomappsinc.techcareergrowth.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.databinding.LessonTagsFragmentBinding

class LessonTagsFragment: Fragment() {

    companion object {

        fun getInstance(): LessonTagsFragment {
            return LessonTagsFragment()
        }
    }

    private var _binding: LessonTagsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LessonTagsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
