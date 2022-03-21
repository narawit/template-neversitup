package com.kaguu.test.coroutine

import app.cash.turbine.test
import com.kaguu.test.coroutine.repository.ExampleRepository
import com.kaguu.test.coroutine.repository.ExampleRepositoryImpl
import com.kaguu.test.coroutine.service.ExampleService
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
@RunWith(MockitoJUnitRunner::class)
class ExampleRepositoryImplTest {
    lateinit var repository: ExampleRepository

    @Mock
    lateinit var service: ExampleService

    @Before
    fun setup() {
        repository = ExampleRepositoryImpl(service)
    }

    @Test
    fun `getData, should return success when call function`() = runBlockingTest {
        //given
        val response = "test"
        whenever(service.fetchData()) doReturn response

        //execute
        val result = repository.fetchData()

        //assert or verify
        result.test {
            awaitItem().shouldBeEqualTo(response)
            awaitComplete()
        }
    }

    @Test
    fun `updateData, should return success when send data to function`() = runBlockingTest {
        //given
        val request = "test"
        val response = "test"
        whenever(service.upDataData(request)) doReturn response

        //execute
        val result = repository.upDateData(request)

        //assert or verify
        result.test {
            awaitItem().shouldBeEqualTo(response)
            awaitComplete()
        }
    }
}