package com.kaguu.data.local.pref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import timber.log.Timber

class PreferenceStorage constructor(
    private val prefs: SharedPreferences
) {
    fun <T> getObject(key: String, defaultValue: String?, type: Class<T>) = try {
        Gson().fromJson(get(key) ?: defaultValue, type)
    } catch (e: JsonSyntaxException) {
        null
    }

    fun <T> putObject(key: String, value: T) {
        put(key, Gson().toJson(value))
    }

    fun getString(key: String, defaultValue: String): String = get(key) ?: defaultValue

    fun putString(key: String, value: String) {
        put(key, value)
    }

    fun getInt(key: String, defaultValue: Int): Int =
        get(key)?.toIntOrNull() ?: defaultValue

    fun putInt(key: String, value: Int) {
        put(key, value)
    }

    fun getLong(key: String, defaultValue: Long): Long =
        get(key)?.toLongOrNull() ?: defaultValue

    fun putLong(key: String, value: Long) {
        put(key, value)
    }

    fun getFloat(key: String, defaultValue: Float): Float =
        get(key)?.toFloatOrNull() ?: defaultValue

    fun putFloat(key: String, value: Float) {
        put(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        get(key)?.toBoolean() ?: defaultValue

    fun putBoolean(key: String, value: Boolean) {
        put(key, value)
    }

    fun getStringSet(key: String): Set<String>? {
        return prefs.getStringSet(key, HashSet())
    }

    fun putStringSet(key: String, set: Set<String>) {
        prefs.edit().putStringSet(key, set).apply()
    }

    fun delete(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun deleteAll() {
        prefs.edit().clear().apply()
    }

    private fun <T> put(key: String, value: T?) {
        try {
            prefs.edit().putString(key, value.toString()).apply()
        } catch (e: Exception) {
            Timber.e("ERROR ~> : ${e.message}")
        }
    }

    private fun get(key: String): String? {
        return try {
            prefs.getString(key, null)
        } catch (e: Exception) {
            null
        }
    }
}