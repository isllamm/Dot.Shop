package com.iei.dotshop.utils

import android.content.Context
import java.util.*

fun updateLanguage(context: Context) {
    //Lingver.getInstance().setLocale(context, getLocale(PrefsHelper.getLanguage()))
}

fun getLocale(language: String): Locale {
    return if (language == Constants.EN) Locale("en", "US")
    else Locale("ar", "EG")
}