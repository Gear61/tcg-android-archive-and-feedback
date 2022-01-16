package com.randomappsinc.techcareergrowth.init

import android.app.Application
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.IoniconsModule
import com.randomappsinc.techcareergrowth.persistence.PreferencesManager
import com.randomappsinc.techcareergrowth.theme.ThemeManager

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Iconify.with(IoniconsModule())
        val preferencesManager = PreferencesManager(this)
        ThemeManager.applyTheme(preferencesManager.themeMode)
    }
}
