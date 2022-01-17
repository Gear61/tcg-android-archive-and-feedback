package com.randomappsinc.techcareergrowth.learning

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
import com.randomappsinc.techcareergrowth.databinding.WatchContentBinding
import com.randomappsinc.techcareergrowth.home.LessonListFragment
import com.randomappsinc.techcareergrowth.home.LessonsAdapter
import com.randomappsinc.techcareergrowth.models.LessonType

class WatchContentFragment: Fragment() {

    companion object {

        fun getInstance(): WatchContentFragment {
            return WatchContentFragment()
        }
    }

    private var _binding: WatchContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WatchContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
