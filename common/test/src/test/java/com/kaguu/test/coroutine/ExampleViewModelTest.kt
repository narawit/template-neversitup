package com.kaguu.test.coroutine

import com.kaguu.test.captureValue
import com.kaguu.test.common.ViewModelTest
import com.kaguu.test.coroutine.usecase.ExampleFetchDataUseCase
import com.kaguu.test.coroutine.usecase.ExampleUpdateDataUseCase
import com.kaguu.test.coroutine.viewmodel.ExampleViewModel
import com.kaguu.test.coroutine.viewmodel.ExampleViewModelImpl
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import org.mockito.Mock

@ExperimentalCoroutinesApi
class ExampleViewModelTest : ViewModelTest<ExampleViewModel>() {
    @Mock
    lateinit var mockExampleFetchDataUseCase: ExampleFetchDataUseCase

    @Mock
    lateinit var mockExampleUpdateDataUseCase: ExampleUpdateDataUseCase

    override fun createViewModel(): ExampleViewModel {
        return ExampleViewModelImpl(
            mockExampleFetchDataUseCase,
            mockExampleUpdateDataUseCase
        )
    }

    @Test
    fun `fetchData, should return success`() = runBlockingTest {
        //given
        val request: Unit = mock()
        val response: String = "Test"
        whenever(mockExampleFetchDataUseCase.execute(request)) doReturn flowOf(response)

        //execute
        viewModel.input.fetchData()

        //assert or verify
        val result = viewModel.data.captureValue()
        result.shouldBeEqualTo(response)

        verify(mockExampleFetchDataUseCase).execute(Unit)
    }

}