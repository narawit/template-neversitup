package com.kaguu.test.rx.presenter

import androidx.lifecycle.LifecycleObserver

interface ExampleView {

    interface View: LoadingContract {

    }

    interface ActiveListener: LifecycleObserver {
        fun getData()
    }
}