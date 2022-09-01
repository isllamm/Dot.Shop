package com.techlife.winwin.core.util

import android.content.Context
import android.os.Parcelable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.google.gson.Gson
import com.iei.dotshop.MyApp

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(DelicateCoroutinesApi::class)
@Singleton
class SessionManager @Inject constructor(val context: Context, val gson: Gson) {

    suspend fun save(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        MyApp.dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    suspend fun read(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = MyApp.dataStore.data.first()
        return preferences[dataStoreKey]
    }
    suspend fun saveBoolean(key: String, value: Boolean) {
        val dataStoreKey = preferencesKey<Boolean>(key)
        MyApp.dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }suspend fun readBoolean(key: String): Boolean? {
        val dataStoreKey = preferencesKey<Boolean>(key)
        val preferences = MyApp.dataStore.data.first()
        return preferences[dataStoreKey]
    }
}

