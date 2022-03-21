package com.kaguu.core.utils.event

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import timber.log.Timber
import java.util.concurrent.atomic.AtomicBoolean

class MutableSingleLiveEvent<T> : SingleLiveEvent<T>() {
    private val mPending = AtomicBoolean(false)

    companion object {
        private val TAG = "SingleLiveEvent"
    }

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            Timber.tag(TAG)
                .w("Multiple observers registered but only one will be notified of changes.")
        }

        // Observe the internal MutableLiveData
        super.observe(owner, Observer { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    public override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    public override fun postValue(value: T) {
        mPending.set(true)
        super.postValue(value)
    }

    @MainThread
    fun call() {
        value = null
    }
}