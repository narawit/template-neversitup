package com.kaguu.test.coroutine.usecase

import com.kaguu.core.base.coroutine.UseCase
import com.kaguu.test.coroutine.repository.ExampleRepository


class ExampleFetchDataUseCase(
    private val repository: ExampleRepository
) : UseCase<Unit, String>() {
    override fun checkRequest(request: Unit) = request

    override suspend fun executeRepo(requestBody: Unit, isRetry: Boolean) =
        repository.fetchData()
}