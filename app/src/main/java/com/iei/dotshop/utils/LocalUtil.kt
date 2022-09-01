package com.techlife.winwin.core.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.view.View
import kotlinx.coroutines.DelicateCoroutinesApi
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by MahmoudAyman on 7/17/2020.
 **/
@OptIn(DelicateCoroutinesApi::class)
@Singleton
class LocalUtil @Inject constructor(val sessionManager: SessionManager) {
    companion object {
        const val ENGLISH_LANG: String = "en"
        const val ARABIC_LANG: String = "ar"
        const val DEFAULT_LANG: String = ENGLISH_LANG
    }

    fun setLocale(context: Context, language: String): Context {
       // sessionManager.setLang(language)
        return if (isBiggerThanOrEqualAndroidN24()) {
            updateResources(context, language)
        } else updateResourcesLegacy(context, language)
    }

    @SuppressLint("NewApi")
    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        if (isBiggerThanOrEqualAndroidN17()) {
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
        }
        return context.createConfigurationContext(configuration)
    }

    @Suppress("Deprecation")
    private fun updateResourcesLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        if (isBiggerThanOrEqualAndroidN17())
            configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }

    private fun isBiggerThanOrEqualAndroidN24(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun isBiggerThanOrEqualAndroidN17(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
    }
/*
    @Suppress("Deprecation")
    fun changeLanguage(activity: AppCompatActivity) {
      //  val lang = sessionManager.getLangBlocking()
        val locale = Locale(lang)
        val activityRes: Resources = activity.resources
        val activityConfig = activityRes.configuration
        if (isBiggerThanOrEqualAndroidN17())
            activityConfig.setLocale(locale)
        activityRes.updateConfiguration(activityConfig, activityRes.displayMetrics)
        val appRes: Resources = activity.applicationContext.resources
        val appConfig = appRes.configuration
        if (isBiggerThanOrEqualAndroidN17())
            appConfig.setLocale(locale)
        appRes.updateConfiguration(
            appConfig,
            appRes.displayMetrics
        )
        when (lang) {
            ARABIC_LANG -> {
                activity.setWindowLayoutDirection(View.LAYOUT_DIRECTION_RTL)
            }
            ENGLISH_LANG -> {
                activity.setWindowLayoutDirection(View.LAYOUT_DIRECTION_LTR)
            }
            else -> View.LAYOUT_DIRECTION_LOCALE
        }
    }*/
}
