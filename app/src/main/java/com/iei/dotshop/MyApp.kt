package com.iei.dotshop

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.iei.dotshop.data.PrefsHelper
import com.iei.dotshop.utils.updateLanguage
import com.yariksoffice.lingver.Lingver
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        PrefsHelper.init(applicationContext)
        Lingver.init(this, Locale("ar", "EG"))
        updateLanguage(applicationContext)
    }
}