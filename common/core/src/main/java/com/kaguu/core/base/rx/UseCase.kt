package com.kaguu.core.base.rx

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.reactivestreams.Subscriber

abstract class UseCase<REQUEST, RESPONSE> : Interactor<REQUEST, RESPONSE> {

	protected abstract fun createObservable(request: REQUEST): Observable<RESPONSE>

	private val compositeDisposable: CompositeDisposable = CompositeDisposable()

	override fun execute(request: REQUEST, subscriber: Subscriber<RESPONSE>) {
		createObservable(request).subscribe()
				.addTo(compositeDisposable)
	}

	override fun execute(request: REQUEST): Observable<RESPONSE> {
		return createObservable(request)
	}
}