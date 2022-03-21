package com.kaguu.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<Request, Result> {

    abstract fun checkRequest(request: Request): Request

    protected abstract suspend fun executeRepo(requestBody: Request, isRetry: Boolean): Flow<Result>

    fun execute(request: Request, statusRetry: Boolean = true): Flow<Result> =
        flow { emit(checkRequest(request)) }
            .flatMapConcat { executeRepo(it, statusRetry) }
}