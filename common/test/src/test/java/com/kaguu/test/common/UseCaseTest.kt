package com.kaguu.test.common

import com.kaguu.core.base.BaseUseCase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime

@ExperimentalTime
@RunWith(MockitoJUnitRunner::class)
abstract class UseCaseTest<UseCase : BaseUseCase<Request, Result>, Request, Result> {
    protected lateinit var usecase: UseCase
    abstract fun createUseCase(): UseCase

    @Before
    open fun setUp() {
        usecase = createUseCase()
    }

    @After
    open fun tearDown() {

    }
}