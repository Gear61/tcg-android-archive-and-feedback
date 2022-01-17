package com.randomappsinc.techcareergrowth.persistence

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.randomappsinc.techcareergrowth.theme.ThemeMode

class PreferencesManager(context: Context?) {

    companion object {

        const val THEME_MODE = "KEY_THEME_MODE"
    }

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var themeMode: Int
        get() = prefs.getInt(THEME_MODE, ThemeMode.FOLLOW_SYSTEM)
        set(newThemeMode) {
            prefs.edit().putInt(THEME_MODE, newThemeMode).apply()
        }

    fun getLessonCompletionStatus(lessonId: String): Boolean {
        return prefs.getBoolean(lessonId, false)
    }

    fun onLessonCompleted(lessonId: String) {
        prefs.edit().putBoolean(lessonId, true).apply()
    }
}
