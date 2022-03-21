package com.kaguu.core.utils.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.kaguu.core.utils.event.SingleLiveEvent
import kotlin.reflect.KFunction1

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <T : Any, L : SingleLiveEvent<T>> LifecycleOwner.observeEvent(
    liveData: L,
    body: KFunction1<T, Unit>
) = liveData.observe(this, Observer(body))