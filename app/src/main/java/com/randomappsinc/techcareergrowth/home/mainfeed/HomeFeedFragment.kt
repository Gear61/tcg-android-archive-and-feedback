package com.randomappsinc.techcareergrowth.home.mainfeed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.common.Constants
import com.randomappsinc.techcareergrowth.databinding.HomeFeedFragmentBinding
import com.randomappsinc.techcareergrowth.learning.LessonActivity
import com.randomappsinc.techcareergrowth.lessonlist.LessonListActivity
import com.randomappsinc.techcareergrowth.models.Lesson
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.util.ListUtil

class HomeFeedFragment : Fragment(), HomeFeedAdapter.Listener, PreferencesManager.Listener {

    companion object {

        fun getInstance(): HomeFeedFragment {
            return HomeFeedFragment()
        }
    }

    private var _binding: HomeFeedFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var preferencesManager: PreferencesManager
    private lateinit var homeFeedAdapter: HomeFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFeedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferencesManager = PreferencesManager.getInstance(view.context)
        preferencesManager.registerListener(listener = this)

        val lessonTypes = preferencesManager.getContentOrder()
        homeFeedAdapter = HomeFeedAdapter(
            lessonTags = lessonTypes,
            listener = this
        )
        binding.homepageList.adapter = homeFeedAdapter
    }

    override fun onLessonCompleted(lessonId: String) {
        homeFeedAdapter.onLessonCompleted(lessonId = lessonId)
    }

    override fun onResume() {
        super.onResume()
        val freshLessonTypes = preferencesManager.getContentOrder()
        if (!ListUtil.areListsEqual(first = freshLessonTypes, second = homeFeedAdapter.lessonTags)) {
            homeFeedAdapter.clear()
            homeFeedAdapter = HomeFeedAdapter(
                lessonTags = freshLessonTypes,
                listener = this
            )
            binding.homepageList.adapter = homeFeedAdapter
        }
    }

    override fun onLessonClicked(lesson: Lesson) {
        val intent = Intent(requireActivity(), LessonActivity::class.java)
        intent.putExtra(LessonActivity.LESSON_KEY, lesson)
        startActivity(intent)
    }

    override fun onLessonTypeClicked(tag: LessonTag) {
        val intent = Intent(requireActivity(), LessonListActivity::class.java)
        intent.putExtra(Constants.LESSON_TYPE_KEY, tag)
        startActivity(intent)
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        requireActivity().overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in)
    }

    override fun onDestroyView() {
        preferencesManager.unregisterListener(listener = this)
        super.onDestroyView()
    }
}
