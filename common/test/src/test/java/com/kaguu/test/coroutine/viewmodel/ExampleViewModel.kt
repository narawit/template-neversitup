package com.kaguu.test.coroutine.viewmodel

import androidx.lifecycle.LiveData
import com.kaguu.core.base.BaseViewModel

abstract class ExampleViewModel : BaseViewModel() {
    abstract val input: Input
    abstract val data: LiveData<String>

    interface Input {
        fun fetchData()
        fun updateData(data: String)
    }
}

