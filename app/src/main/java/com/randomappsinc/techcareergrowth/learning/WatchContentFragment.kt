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
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.WatchContentBinding
import com.randomappsinc.techcareergrowth.webutils.VideoEnabledWebChromeClient

class WatchContentFragment : Fragment() {

    companion object {
        fun getInstance(): WatchContentFragment {
            return WatchContentFragment()
        }
    }

    private var _mBinding: WatchContentBinding? = null
    private val mBinding get() = _mBinding!!

    private lateinit var mWebView: WebView

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
        _mBinding = WatchContentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as LessonActivity
        val lesson = activity.lesson
        mBinding.apply {
            mWebView = youtubeWebView
            lessonTitle.text = getString(lesson.nameResId)
            takeQuizButton.setOnClickListener {
                activity.takeQuiz()
            }

        }

        mWebView.apply {
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    return false
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    mBinding.webViewSkeleton.visibility = View.GONE
                    mWebView.visibility = View.VISIBLE
                }

            }

            val webSettings: WebSettings = settings
            webSettings.javaScriptEnabled = true
            webSettings.loadWithOverviewMode = true
            webSettings.useWideViewPort = true
            webSettings.javaScriptCanOpenWindowsAutomatically = true

            webChromeClient = getFullScreenWebChromeClient()
            loadUrl(lesson.getYouTubeEmbedUrl())
        }
    }

    private fun getFullScreenWebChromeClient(): VideoEnabledWebChromeClient {
        val activity = requireActivity() as LessonActivity
        val webChromeClient =
            VideoEnabledWebChromeClient(
                mBinding.nonFullScreenVideo,
                mBinding.fullScreenVideo,
                null,
                mWebView
            )
        webChromeClient.setOnToggledFullscreen { fullscreen ->
            if (fullscreen) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                activity.supportActionBar?.hide()
            } else {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                activity.supportActionBar?.show()
            }
        }
        return webChromeClient
    }
}
