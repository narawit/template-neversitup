package com.kaguu.test.coroutine

import app.cash.turbine.test
import com.kaguu.test.common.UseCaseTest
import com.kaguu.test.coroutine.repository.ExampleRepository
import com.kaguu.test.coroutine.usecase.ExampleFetchDataUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import org.mockito.Mock
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
class ExampleUseCaseTest :
    UseCaseTest<ExampleFetchDataUseCase, Unit, String>() {

    @Mock
    lateinit var repository: ExampleRepository
    override fun createUseCase() = ExampleFetchDataUseCase(repository)

    @Test
    fun `execute, should return success`() =
        runBlockingTest {
            //given
            val response = "test"
            whenever(repository.fetchData()) doReturn flowOf(response)

            //execute
            val result = usecase.execute(Unit)

            //assert or verify
            result.test {
                awaitItem().shouldBeEqualTo(response)
                awaitComplete()
            }
            verify(repository).fetchData()
            verifyNoMoreInteractions(repository)
        }
}