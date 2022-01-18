package com.randomappsinc.techcareergrowth.learning

import android.annotation.SuppressLint
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
import android.webkit.WebSettings
import android.webkit.WebView

import android.webkit.WebViewClient




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

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val youtubeWebView = binding.youtubeWebView
        youtubeWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.webViewSkeleton.visibility = View.GONE
                youtubeWebView.visibility = View.VISIBLE
            }
        }

        val webSettings: WebSettings = youtubeWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true

        val activity = requireActivity() as LessonActivity
        val lesson = activity.lesson
        youtubeWebView.loadUrl(lesson.getYouTubeEmbedUrl())
    }
}
