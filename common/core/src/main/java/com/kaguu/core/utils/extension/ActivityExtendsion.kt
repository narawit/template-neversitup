package com.kaguu.core.utils.extension

import android.app.Activity
import timber.log.Timber

fun Activity.log(message: String) {
    Timber.v(message)
}