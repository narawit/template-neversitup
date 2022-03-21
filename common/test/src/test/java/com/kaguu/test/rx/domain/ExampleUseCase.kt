package com.kaguu.test.rx.domain

import com.kaguu.core.base.rx.UseCase
import com.kaguu.test.rx.datasource.ExampleRepository
import io.reactivex.Observable

class ExampleUseCase constructor(
    val dataSource: ExampleRepository
) : UseCase<Unit, String>() {

    override fun createObservable(request: Unit): Observable<String> {
        return dataSource.requestData()
    }
}