package com.randomappsinc.techcareergrowth.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.contentproviders.LessonProvider
import com.randomappsinc.techcareergrowth.databinding.LessonListBinding
import com.randomappsinc.techcareergrowth.learning.LessonActivity
import com.randomappsinc.techcareergrowth.models.LessonType

class LessonListFragment: Fragment(), LessonsAdapter.SelectionListener {

    companion object {

        private const val LESSON_TYPE_KEY = "lesson_type"
        const val FIRST_TIME_COMPLETION_CODE = 420

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
    private lateinit var lessonsAdapter: LessonsAdapter
    private var clickedPosition = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LessonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lessonType: LessonType = requireArguments().getSerializable(LESSON_TYPE_KEY) as LessonType
        val lessons = LessonProvider.getLessonList(
            type = lessonType,
            context = requireContext()
        )

        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.line_divider)!!)
        binding.lessonList.addItemDecoration(itemDecorator)
        lessonsAdapter = LessonsAdapter(
            lessons = lessons,
            selectionListener = this
        )
        binding.lessonList.adapter = lessonsAdapter
    }

    override fun onLessonClicked(position: Int) {
        clickedPosition = position

        val activity = requireActivity()
        val intent = Intent(activity, LessonActivity::class.java)
        intent.putExtra(LessonActivity.LESSON_KEY, lessonsAdapter.lessons[position])
        startActivityForResult(intent, 1)
        requireActivity().overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == FIRST_TIME_COMPLETION_CODE) {
            lessonsAdapter.onLessonCompleted(lessonPosition = clickedPosition)
        }
    }
}
