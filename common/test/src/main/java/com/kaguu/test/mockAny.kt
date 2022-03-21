package com.kaguu.test

import org.mockito.Mockito

fun <T> UtilAny(): T {
    Mockito.any<T>()
    return uninitialized()
}
private fun <T> uninitialized(): T = null as T