package com.kaguu.core.utils

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.util.DisplayMetrics

class MyContextWrapper(base: Context) : ContextWrapper(base) {
    companion object {
        private fun Configuration.adjustFontScale(): Configuration =
            this.apply { fontScale = 1f }

        private fun Configuration.adjustDisplayScale(): Configuration =
            this.apply { densityDpi = DisplayMetrics.DENSITY_DEVICE_STABLE }

        private fun Configuration.createConfigurationContext(context: Context): Context =
            context.createConfigurationContext(this)

        fun wrap(context: Context): ContextWrapper =
            MyContextWrapper(
                context.resources.configuration
//                    .adjustFontScale()
                    .createConfigurationContext(context)
            )
    }
}