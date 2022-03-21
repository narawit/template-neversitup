package com.kaguu.core.base.rx

import io.reactivex.Observable
import org.reactivestreams.Subscriber


interface Interactor<in REQUEST, RESPONSE> {
	fun execute(request: REQUEST, subscriber: Subscriber<RESPONSE>)

	fun execute(request: REQUEST): Observable<RESPONSE>
}