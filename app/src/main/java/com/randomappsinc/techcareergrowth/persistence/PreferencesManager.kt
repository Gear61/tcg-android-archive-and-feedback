package com.randomappsinc.techcareergrowth.persistence

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.randomappsinc.techcareergrowth.common.SingletonHolder
import com.randomappsinc.techcareergrowth.models.LessonTag
import com.randomappsinc.techcareergrowth.theme.ThemeMode

class PreferencesManager private constructor(context: Context) {

    interface Listener {
        fun onLessonCompleted(lessonId: String)
    }

    companion object : SingletonHolder<PreferencesManager, Context>(::PreferencesManager) {

        const val KEY_HAS_SEEN_SLIDESHOW = "KEY_HAS_SEEN_SLIDESHOW"

        const val THEME_MODE = "KEY_THEME_MODE"
        const val NUM_APP_OPENS = "NUM_APP_OPENS"
        const val KEY_CONTENT_ORDER = "KEY_CONTENT_ORDER"

        const val APP_OPENS_FOR_RATING_UPSELL = 5
    }

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val listeners = mutableListOf<Listener>()

    var hasSeenSlideshow: Boolean
        get() = prefs.getBoolean(KEY_HAS_SEEN_SLIDESHOW, false)
        set(newHasSeenSlideshow) {
            prefs.edit().putBoolean(KEY_HAS_SEEN_SLIDESHOW, newHasSeenSlideshow).apply()
        }

    var themeMode: Int
        get() = prefs.getInt(THEME_MODE, ThemeMode.FOLLOW_SYSTEM)
        set(newThemeMode) {
            prefs.edit().putInt(THEME_MODE, newThemeMode).apply()
        }

    fun getContentOrder(): MutableList<LessonTag> {
        val orderedTypes = prefs.getString(KEY_CONTENT_ORDER, "")
        val defaultTypes = mutableListOf(
            LessonTag.INTERVIEWING,
            LessonTag.RESUME,
            LessonTag.PRODUCTIVITY,
            LessonTag.PROMOTION,
            LessonTag.LEARNING_QUICKLY,
            LessonTag.MEETINGS
        )

        if (orderedTypes!!.isEmpty()) {
            return defaultTypes
        } else {
            val splitUpTypes = orderedTypes.split(",")
            val lessonTypes = mutableListOf<LessonTag>()
            for (type in splitUpTypes) {
                lessonTypes.add(LessonTag.valueOf(type))
            }

            for (defaultType in defaultTypes) {
                if (!lessonTypes.contains(defaultType)) {
                    lessonTypes.add(defaultType)
                }
            }

            return lessonTypes
        }
    }

    fun setContentOrder(lessonTags: List<LessonTag>) {
        val typesString = StringBuilder()
        for (type in lessonTags) {
            if (typesString.isNotEmpty()) {
                typesString.append(",")
            }
            typesString.append(type.toString())
        }
        prefs.edit().putString(KEY_CONTENT_ORDER, typesString.toString()).apply()
    }

    fun getLessonCompletionStatus(lessonId: String): Boolean {
        return prefs.getBoolean(lessonId, false)
    }

    fun onLessonCompleted(lessonId: String) {
        prefs.edit().putBoolean(lessonId, true).apply()
        for (listener in listeners) {
            listener.onLessonCompleted(lessonId = lessonId)
        }
    }

    fun logAppOpenAndCheckForRatingUpsell(): Boolean {
        val currentAppOpens = prefs.getInt(NUM_APP_OPENS, 0) + 1
        prefs.edit().putInt(NUM_APP_OPENS, currentAppOpens).apply()
        return currentAppOpens == APP_OPENS_FOR_RATING_UPSELL
    }

    fun registerListener(listener: Listener) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        listeners.remove(listener)
    }
}
