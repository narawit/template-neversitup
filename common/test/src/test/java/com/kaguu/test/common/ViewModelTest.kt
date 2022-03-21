package com.kaguu.test.common

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kaguu.core.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
abstract class ViewModelTest<V : BaseViewModel> {
    val testDispatcher = TestCoroutineDispatcher()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    protected lateinit var viewModel: V
    abstract fun createViewModel(): V

    @Before
    open fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = createViewModel()
        viewModel.setDispatcher(testDispatcher)
    }

    @After
    open fun tearDown() {
        Dispatchers.resetMain()
    }
}