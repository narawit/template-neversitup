package com.kaguu.test.rx.presenter

import androidx.lifecycle.LifecycleObserver
import com.kaguu.core.base.rx.RxPresenter
import com.kaguu.test.rx.domain.ExampleUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ExamplePresenter(
    private val view: ExampleView.View,
    private val viewModel: ExampleViewModel,
    private val useCase: ExampleUseCase,
    compositeDisposable: CompositeDisposable
) : ExampleView.ActiveListener, RxPresenter(compositeDisposable) {

    private fun observableData(): Observable<String> {

        return useCase.execute(Unit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {

            }
            .doOnError {

            }
    }

    override fun getData() {
        observableData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext = {

            }, onError = {})
            .addTo(compositeDisposable)
    }

}