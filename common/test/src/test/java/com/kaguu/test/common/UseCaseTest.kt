package com.kaguu.test.common

import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.time.ExperimentalTime

@ExperimentalTime
@RunWith(MockitoJUnitRunner::class)
abstract class UseCaseTest<UseCase : com.kaguu.core.base.coroutine.UseCase<Request, Result>, Request, Result> {
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