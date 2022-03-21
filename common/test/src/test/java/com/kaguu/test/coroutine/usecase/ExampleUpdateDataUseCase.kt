package com.kaguu.test.coroutine.usecase

import com.kaguu.core.base.coroutine.UseCase
import com.kaguu.test.coroutine.repository.ExampleRepository


class ExampleUpdateDataUseCase(
    private val repository: ExampleRepository
) : UseCase<String, String>() {
    override fun checkRequest(request: String) = request

    override suspend fun executeRepo(requestBody: String, isRetry: Boolean) =
        repository.upDateData(requestBody)
}