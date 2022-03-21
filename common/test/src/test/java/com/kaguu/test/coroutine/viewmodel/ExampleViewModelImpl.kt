package com.kaguu.test.coroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kaguu.test.coroutine.usecase.ExampleFetchDataUseCase
import com.kaguu.test.coroutine.usecase.ExampleUpdateDataUseCase
import kotlinx.coroutines.launch

class ExampleViewModelImpl(
    private val exampleFetchDataUseCase: ExampleFetchDataUseCase,
    private val exampleUpdateDataUseCase: ExampleUpdateDataUseCase
) : ExampleViewModel(), ExampleViewModel.Input {

    override val input: Input
        get() = this

    private val _data = MutableLiveData<String>()
    override val data: LiveData<String> = _data

    override fun fetchData() {
        viewModelScope.launch {
            exampleFetchDataUseCase.execute(Unit)
                .onSuccess {
                    _data.postValue(it)
                }
        }
    }

    override fun updateData(data: String) {
        viewModelScope.launch {
            exampleUpdateDataUseCase.execute(data)
                .onSuccess {
                    _data.postValue(it)
                }
        }
    }

}