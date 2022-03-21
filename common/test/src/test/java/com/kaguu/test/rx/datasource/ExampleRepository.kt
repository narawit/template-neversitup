package com.kaguu.test.rx.datasource

class ExampleRepository constructor(
    private val remoteDataSource: ExampleDataSource
) : ExampleDataSource by remoteDataSource