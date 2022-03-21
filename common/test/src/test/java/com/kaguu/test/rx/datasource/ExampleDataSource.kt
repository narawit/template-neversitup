package com.kaguu.test.rx.datasource

import io.reactivex.Observable

interface ExampleDataSource {
    fun requestData(): Observable<String>
}