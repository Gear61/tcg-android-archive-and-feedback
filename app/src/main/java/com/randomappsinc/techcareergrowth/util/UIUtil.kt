package com.randomappsinc.techcareergrowth.util

import android.content.Context
import android.graphics.Color
import android.view.Menu
import android.widget.CompoundButton
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.joanzapata.iconify.Icon
import com.joanzapata.iconify.IconDrawable
import com.randomappsinc.techcareergrowth.R

object UIUtil {

    fun loadMenuIcon(menu: Menu, itemId: Int, icon: Icon?, context: Context?) {
        menu.findItem(itemId).icon = IconDrawable(context, icon)
            .colorRes(R.color.white)
            .actionBarSize()
    }

    fun setCheckedImmediately(checkableView: CompoundButton, checked: Boolean) {
        checkableView.isChecked = checked
        checkableView.jumpDrawablesToCurrentState()
    }

    fun showShortToast(@StringRes stringId: Int, context: Context) {
        showToast(stringId, Toast.LENGTH_SHORT, context)
    }

    fun showLongToast(@StringRes stringId: Int, context: Context) {
        showToast(stringId, Toast.LENGTH_LONG, context)
    }

    private fun showToast(@StringRes stringId: Int, duration: Int, context: Context) {
        Toast.makeText(context, stringId, duration).show()
    }

    fun getInBetweenColor(
        context: Context,
        @ColorRes startColorResId: Int,
        @ColorRes endColorResId: Int,
        progressTowardsEnd: Float): Int
    {
        val startColor = ContextCompat.getColor(context, startColorResId)
        val endColor = ContextCompat.getColor(context, endColorResId)

        val startRed = Color.red(startColor)
        val startGreen = Color.green(startColor)
        val startBlue = Color.blue(startColor)

        val endRed = Color.red(endColor)
        val endGreen = Color.green(endColor)
        val endBlue = Color.blue(endColor)

        val redDelta = (endRed - startBlue).toFloat()
        val greenDelta = (endGreen - startGreen).toFloat()
        val blueDelta = (endBlue - startBlue).toFloat()

        val finalRed = startRed + (redDelta * progressTowardsEnd).toInt()
        val finalGreen = startGreen + (greenDelta * progressTowardsEnd).toInt()
        val finalBlue = startBlue + (blueDelta * progressTowardsEnd).toInt()

        return Color.rgb(finalRed, finalGreen, finalBlue)
    }
}
