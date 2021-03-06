package com.randomappsinc.techcareergrowth.home.lessontags

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.randomappsinc.techcareergrowth.common.Constants
import com.randomappsinc.techcareergrowth.contentproviders.LessonProvider
import com.randomappsinc.techcareergrowth.databinding.LessonTagsFragmentBinding
import com.randomappsinc.techcareergrowth.lessonlist.LessonListActivity
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager

class LessonTagsFragment: Fragment(), LessonTagsAdapter.Listener, PreferencesManager.Listener {

    companion object {

        fun getInstance(): LessonTagsFragment {
            return LessonTagsFragment()
        }
    }

    private var _binding: LessonTagsFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var tagsAdapter: LessonTagsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LessonTagsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val allTags = LessonTag.values()
        val tagViewModels = mutableListOf<LessonTagViewModel>()
        for (tag in allTags) {
            tagViewModels.add(
                LessonTagViewModel(
                    tag = tag,
                    lessons = LessonProvider.getLessonList(
                        tag = tag,
                        context = view.context
                    ),
                    tagLabel = getString(tag.overallLabelId)
                )
            )
        }
        tagViewModels.sortBy { it.tagLabel }

        tagsAdapter = LessonTagsAdapter(
            viewModels = tagViewModels,
            listener = this
        )
        binding.tagsList.adapter = tagsAdapter

        PreferencesManager.getInstance(view.context).registerListener(this)
    }

    override fun onTagClicked(tag: LessonTag) {
        val intent = Intent(requireActivity(), LessonListActivity::class.java)
        intent.putExtra(Constants.LESSON_TYPE_KEY, tag)
        startActivity(intent)
    }

    override fun onLessonCompleted(lessonId: String) {
        tagsAdapter.onLessonCompleted(lessonId = lessonId)
    }

    override fun onDestroyView() {
        PreferencesManager.getInstance(requireContext()).unregisterListener(this)
        super.onDestroyView()
    }
}
