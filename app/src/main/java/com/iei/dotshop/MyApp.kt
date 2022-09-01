package com.iei.dotshop

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.iei.dotshop.utils.updateLanguage
import com.yariksoffice.lingver.Lingver
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp

class MyApp : Application() {
    companion object CompanionObject {

        lateinit var dataStore: DataStore<Preferences>
    }
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataStore = createDataStore(name = "settings")

        Lingver.init(this, Locale("ar", "EG"))
        updateLanguage(applicationContext)
    }
}

