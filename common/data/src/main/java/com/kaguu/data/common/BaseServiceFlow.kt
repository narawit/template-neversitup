package com.kaguu.data.common

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.net.SocketException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

abstract class BaseServiceFlow<Response, Model> {

    abstract suspend fun callService(): Response

    abstract fun mapResponse(from: Response): Model

    open fun isRetry(): Boolean = true

    open fun execute(): Flow<Model> =
        flow { emit(checkInternetConnection()) }
            .map { callService() }
            .retryWhen { cause, attempt -> validateRetry(cause, attempt, isRetry()) }
            .map { mapResponse(it) }
            .catch { e: Throwable -> mapError(e) }

    open suspend fun validateRetry(
        cause: Throwable,
        attempt: Long,
        isRetry: Boolean
    ): Boolean =
        if (isRetry && EXCEPTION_TO_RETRY.contains(cause::class) && attempt < RETRY_MAX) {
            delay(RETRY_DELAY_SECOND)
            true
        } else {
            false
        }

    protected fun mapError(error: Throwable) {
        throw error
    }

    protected fun checkInternetConnection() {

    }

    protected companion object {
        const val RETRY_MAX = 1
        const val RETRY_DELAY_SECOND = 5L
        val EXCEPTION_TO_RETRY =
            listOf(
                SocketTimeoutException::class,
                SocketException::class,
                TimeoutException::class
            )
    }
}
