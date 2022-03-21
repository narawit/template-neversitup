package com.kaguu.core.base.rx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

open class RxPresenter constructor(val compositeDisposable: CompositeDisposable) :
		LifecycleObserver {

	@OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
	open fun onDestroy() {
		compositeDisposable.dispose()
	}
}