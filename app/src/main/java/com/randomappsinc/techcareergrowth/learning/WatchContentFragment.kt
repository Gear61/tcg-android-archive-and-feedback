package com.randomappsinc.techcareergrowth.learning

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.WatchContentBinding
import com.randomappsinc.techcareergrowth.web.VideoEnabledWebChromeClient

class WatchContentFragment: Fragment() {

    companion object {

        fun getInstance(): WatchContentFragment {
            return WatchContentFragment()
        }
    }

    private var _binding: WatchContentBinding? = null
    private val binding get() = _binding!!

    private lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.fade)
    }

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
        val activity = requireActivity() as LessonActivity
        toolbar = activity.supportActionBar!!

        val lesson = activity.lesson
        binding.lessonTitle.setText(lesson.nameResId)

        bindWebView(youTubeUrl = lesson.getYouTubeEmbedUrl())
        binding.takeQuizButton.setOnClickListener {
            activity.takeQuiz()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun bindWebView(youTubeUrl: String) {
        val youTubeWebView = binding.youtubeWebView
        youTubeWebView.apply {
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    return false
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.webViewSkeleton.visibility = View.GONE
                    youTubeWebView.visibility = View.VISIBLE
                }
            }

            val webSettings: WebSettings = settings
            webSettings.javaScriptEnabled = true
            webSettings.loadWithOverviewMode = true
            webSettings.useWideViewPort = true
            webSettings.javaScriptCanOpenWindowsAutomatically = true

            val videoEnabledChromeClient =
                VideoEnabledWebChromeClient(
                    binding.nonFullScreenVideo,
                    binding.fullScreenVideo,
                    null
                )

            videoEnabledChromeClient.setOnToggledFullscreen(object :
                VideoEnabledWebChromeClient.ToggledFullscreenCallback {
                override fun toggledFullscreen(fullscreen: Boolean) {
                    if (fullscreen) {
                        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                        toolbar.hide()
                    } else {
                        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                        toolbar.show()
                    }
                }
            })
            webChromeClient = videoEnabledChromeClient
            loadUrl(youTubeUrl)
        }
    }
}
