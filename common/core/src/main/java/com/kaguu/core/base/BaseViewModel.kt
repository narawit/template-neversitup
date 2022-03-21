package com.kaguu.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaguu.core.model.ErrorModel
import com.kaguu.core.utils.event.MutableSingleLiveEvent
import com.kaguu.core.utils.event.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
    protected val _loading = MutableSingleLiveEvent<Boolean>()
    val loading: SingleLiveEvent<Boolean> = _loading

    protected val _throwable = MutableLiveData<Throwable>()
    protected val _message = MutableLiveData<String>()

    fun setLoading(flag: Boolean) {
        _loading.postValue(flag)
    }

    protected val _error = MediatorLiveData<ErrorModel>().apply {
        addSource(_throwable) { updateErrorModel(it) }
        addSource(_message) { updateErrorModel(it) }
    }

    private fun updateErrorModel(error: Throwable) {
        // TODO handle case
        ErrorModel(ErrorModel.THROWABLE, error.message)
    }

    private fun updateErrorModel(message: String) {
        _error.postValue(ErrorModel(ErrorModel.MESSAGE, message))
    }

    val error: LiveData<ErrorModel> = _error

    var coroutineContext: CoroutineContext = Dispatchers.IO

    fun setDispatcher(coroutineContext: CoroutineContext) {
        this.coroutineContext = coroutineContext
    }

    suspend fun <R> Flow<R>.onSuccess(action: suspend (value: R) -> Unit) {
        return this.flowOn(coroutineContext)
            .onStart { setLoading(true) }
            .onCompletion { setLoading(false) }
            .catch { _throwable.postValue(it) }
            .collect(action)
    }
}