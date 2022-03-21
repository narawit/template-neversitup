package com.kaguu.data.remote.retrofit

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class OkHttpBuilder(val context: Context) {
    fun build(vararg interceptors: Interceptor) = OkHttpClient.Builder().apply {

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message -> Timber.d(message) }
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }

        interceptors.asList().forEach { interceptor ->
            addInterceptor(interceptor)
        }
    }.build()
}