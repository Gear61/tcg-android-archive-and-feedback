package com.randomappsinc.techcareergrowth.home

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import com.randomappsinc.techcareergrowth.R
import com.randomappsinc.techcareergrowth.databinding.HomeBottomNavigationBinding

class BottomNavigationView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context!!, attrs, defStyle) {

    interface Listener {
        fun onNavItemSelected(@IdRes viewId: Int)
    }

    private var homeButton: TextView
    private var lessonTagsButton: TextView

    var itemColor = ContextCompat.getColor(context!!, R.color.bottom_navigation_item_color)
    var selectedItemColor = ContextCompat.getColor(context!!, R.color.accent_color)

    private var listener: Listener? = null
    private var currentlySelected: TextView?

    init {
        inflate(getContext(), R.layout.home_bottom_navigation, this)
        val binding = HomeBottomNavigationBinding.bind(this)
        homeButton = binding.home
        lessonTagsButton = binding.lessonTags
        currentlySelected = homeButton

        setUpHomeButton()
        setUpActivityFeedButton()
    }

    fun setCurrentlySelected(@IdRes currentlySelected: Int) {
        if (currentlySelected == R.id.home) {
            this.currentlySelected = homeButton
            homeButton.setTextColor(selectedItemColor)
            lessonTagsButton.setTextColor(itemColor)
        } else if (currentlySelected == R.id.lesson_tags) {
            this.currentlySelected!!.setTextColor(itemColor)
            this.currentlySelected = lessonTagsButton
            lessonTagsButton.setTextColor(selectedItemColor)
        }
    }

    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    private fun setUpHomeButton() {
        homeButton.setTextColor(selectedItemColor)
        homeButton.setOnClickListener {
            if (currentlySelected === homeButton) {
                return@setOnClickListener
            }
            currentlySelected!!.setTextColor(itemColor)
            currentlySelected = homeButton
            homeButton.setTextColor(selectedItemColor)
            listener!!.onNavItemSelected(R.id.home)
        }
    }

    private fun setUpActivityFeedButton() {
        lessonTagsButton.setTextColor(itemColor)
        lessonTagsButton.setOnClickListener {
            if (currentlySelected === lessonTagsButton) {
                return@setOnClickListener
            }
            currentlySelected!!.setTextColor(itemColor)
            currentlySelected = lessonTagsButton
            lessonTagsButton.setTextColor(selectedItemColor)
            listener!!.onNavItemSelected(R.id.lesson_tags)
        }
    }
}
