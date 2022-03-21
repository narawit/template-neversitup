package com.kaguu.test.coroutine.repository

import com.kaguu.test.coroutine.service.ExampleService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExampleRepositoryImpl(
    exampleService: ExampleService
) : ExampleRepository {
    override suspend fun fetchData(): Flow<String> {
        return flow { emit("test") }
    }

    override suspend fun upDateData(data: String): Flow<String> {
        return flow { emit(data) }
    }
}