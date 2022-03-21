package com.kaguu.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


inline fun <reified T> LiveData<T>.captureValues(): List<T?> {
    val mockObserver = mockk<Observer<T>>()
    val list = mutableListOf<T?>()
    every { mockObserver.onChanged(captureNullable(list)) } just runs
    this.observeForever(mockObserver)
    return list
}

//inline fun <reified T> LiveData<T>.captureValue(): T? {
//    val mockObserver = mockk<Observer<T>>()
//    val list = mutableListOf<T?>()
//    every { mockObserver.onChanged(captureNullable(list)) } just runs
//    this.observeForever(mockObserver)
//    return list.getOrNull(0)
//}

fun <T> LiveData<T>.captureValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T? {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@captureValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    afterObserve.invoke()

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        this.removeObserver(observer)
//        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}