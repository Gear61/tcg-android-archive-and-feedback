package com.randomappsinc.techcareergrowth.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.databinding.LessonListBinding
import com.randomappsinc.techcareergrowth.models.LessonType

class LessonListFragment: Fragment() {

    companion object {

        private const val LESSON_TYPE_KEY = "lesson_type"

        fun getInstance(lessonType: LessonType): LessonListFragment {
            val bundle = Bundle()
            bundle.putSerializable(LESSON_TYPE_KEY, lessonType)
            val fragment = LessonListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: LessonListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LessonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lessonType = requireArguments().getSerializable(LESSON_TYPE_KEY)
        // Do binding stuff here
    }
}
