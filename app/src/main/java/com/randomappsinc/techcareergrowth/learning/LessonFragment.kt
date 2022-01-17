package com.randomappsinc.techcareergrowth.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.databinding.LessonBinding

class LessonFragment: Fragment() {

    companion object {

        fun getInstance(): LessonFragment {
            return LessonFragment()
        }
    }

    private var _binding: LessonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LessonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Do binding stuff here
    }
}