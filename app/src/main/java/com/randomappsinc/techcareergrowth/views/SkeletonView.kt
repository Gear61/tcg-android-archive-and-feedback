package com.randomappsinc.techcareergrowth.views

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.randomappsinc.techcareergrowth.R

open class SkeletonView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val colorAnimator: ValueAnimator
    private var from = FloatArray(3)
    private var to = FloatArray(3)

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        colorAnimator.start()
    }

    public override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        colorAnimator.cancel()
    }

    init {
        val startColor = ContextCompat.getColor(context, R.color.skeleton_start)
        val endColor = ContextCompat.getColor(context, R.color.skeleton_end)

        Color.colorToHSV(startColor, from)
        Color.colorToHSV(endColor, to)
        colorAnimator = ValueAnimator.ofFloat(0f, 1f)
        colorAnimator.duration =
            context.resources.getInteger(R.integer.skeleton_animation_length_ms).toLong()
        colorAnimator.repeatCount = ValueAnimator.INFINITE
        colorAnimator.repeatMode = ValueAnimator.REVERSE
        val hsv = FloatArray(3)
        colorAnimator.addUpdateListener { animation ->
            // Transition along each axis of HSV (hue, saturation, value)
            hsv[0] = from[0] + (to[0] - from[0]) * animation.animatedFraction
            hsv[1] = from[1] + (to[1] - from[1]) * animation.animatedFraction
            hsv[2] = from[2] + (to[2] - from[2]) * animation.animatedFraction
            setBackgroundColor(Color.HSVToColor(hsv))
        }
    }
}