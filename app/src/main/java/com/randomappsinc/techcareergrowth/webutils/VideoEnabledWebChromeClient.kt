package com.randomappsinc.techcareergrowth.webutils

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.media.MediaPlayer.OnPreparedListener
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.FrameLayout

/**
 * This class serves as a WebChromeClient to be set to a WebView, allowing it to play video.
 * Video will play differently depending on target API level (in-line, fullscreen, or both).
 * Could support having a loading screen when changing orientation if needed in the future
 */
class VideoEnabledWebChromeClient
/**
 * Builds a video enabled WebChromeClient.
 * @param activityNonVideoView A View in the activity's layout that contains every other view that should be hidden when the video goes full-screen.
 * @param activityVideoView A ViewGroup in the activity's layout that will display the video. Typically you would like this to fill the whole layout.
 * @param loadingView A View to be shown while the video is loading (typically only used in API level <11). Must be already inflated and not attached to a parent view.
 * @param webView The owner VideoEnabledWebView. Passing it will enable the VideoEnabledWebChromeClient to detect the HTML5 video ended event and exit full-screen.
 * Note: The web page must only contain one video tag in order for the HTML5 video ended event to work. This could be improved if needed (see Javascript code).
 */(
    private var activityNonVideoView: View?,
    private var activityVideoView: ViewGroup?,
    private var loadingView: View?,
    private var webView: WebView?
) : WebChromeClient(), OnPreparedListener, OnCompletionListener,
    MediaPlayer.OnErrorListener {

    interface ToggledFullscreenCallback {
        fun toggledFullscreen(fullscreen: Boolean)
    }

    private var isVideoFullscreen = false
    private var videoViewContainer: FrameLayout? = null
    private var videoViewCallback: CustomViewCallback? = null
    private var toggledFullscreenCallback: ToggledFullscreenCallback? = null

    init {
        isVideoFullscreen = false
    }

    /**
     * Set a callback that will be fired when the video starts or finishes displaying using a custom view (typically full-screen)
     * @param callback A VideoEnabledWebChromeClient.ToggledFullscreenCallback callback
     */
    fun setOnToggledFullscreen(callback: ToggledFullscreenCallback?) {
        toggledFullscreenCallback = callback
    }

    override fun onShowCustomView(view: View, callback: CustomViewCallback) {
        if (view is FrameLayout) {
            // A video wants to be shown
            // Save video related variables
            isVideoFullscreen = true
            videoViewContainer = view
            videoViewCallback = callback

            // Hide the non-video view, add the video view, and show it
            activityNonVideoView?.visibility = View.INVISIBLE
            activityVideoView?.addView(
                videoViewContainer,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
            activityVideoView?.visibility = View.VISIBLE

            // Notify full-screen change
            if (toggledFullscreenCallback != null) {
                toggledFullscreenCallback?.toggledFullscreen(true)
            }
        }
    }

    override fun onHideCustomView() {
        // This method should be manually called on video end in all cases because it's not always called automatically.
        // This method must be manually called on back key press (from this class' onBackPressed() method).
        if (isVideoFullscreen) {
            // Hide the video view, remove it, and show the non-video view
            activityVideoView?.visibility = View.INVISIBLE
            activityVideoView?.removeView(videoViewContainer)
            activityNonVideoView?.visibility = View.VISIBLE

            // Call back (only in API level <19, because in API level 19+ with chromium webview it crashes)
            if (videoViewCallback != null && !videoViewCallback!!.javaClass.name.contains(".chromium.")) {
                videoViewCallback?.onCustomViewHidden()
            }

            // Reset video related variables
            isVideoFullscreen = false
            videoViewContainer = null
            videoViewCallback = null

            // Notify full-screen change
            if (toggledFullscreenCallback != null) {
                toggledFullscreenCallback?.toggledFullscreen(false)
            }
        }
    }

    override fun getVideoLoadingProgressView(): View? {
        return if (loadingView != null) {
            loadingView?.visibility = View.VISIBLE
            loadingView
        } else {
            super.getVideoLoadingProgressView()
        }
    }

    override fun onPrepared(mp: MediaPlayer) // Video will start playing, only called in the case of android.widget.VideoView (typically API level <11)
    {
        if (loadingView != null) {
            loadingView?.visibility = View.GONE
        }
    }

    override fun onCompletion(mp: MediaPlayer) // Video finished playing, only called in the case of android.widget.VideoView (typically API level <11)
    {
        onHideCustomView()
    }

    override fun onError(
        mp: MediaPlayer,
        what: Int,
        extra: Int
    ): Boolean // Error while playing video, only called in the case of android.widget.VideoView (typically API level <11)
    {
        return false // By returning false, onCompletion() will be called
    }

    /**
     * Notifies the class that the back key has been pressed by the user.
     * This must be called from the Activity's onBackPressed(), and if it returns false, the activity itself should handle it. Otherwise don't do anything.
     * @return Returns true if the event was handled, and false if was not (video view is not visible)
     */
    fun onBackPressed(): Boolean {
        return if (isVideoFullscreen) {
            onHideCustomView()
            true
        } else {
            false
        }
    }
}