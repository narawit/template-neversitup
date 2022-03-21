package com.kaguu.test.coroutine.repository

import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    suspend fun fetchData(): Flow<String>
    suspend fun upDateData(data: String): Flow<String>
}