package com.kaguu.core.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.ViewBinding
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.kaguu.core.model.ErrorModel
import com.kaguu.core.utils.MyContextWrapper
import com.kaguu.core.utils.extension.observe

abstract class BaseActivity<T : ViewBinding> : LocalizationActivity() {
    protected lateinit var binding: T
    abstract fun getViewModels(): List<BaseViewModel>?
    abstract fun getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = getViewBinding()
        setContentView(binding.root)
        initView()
        observer()
    }

    open fun initView() {}
    open fun observer() {
        getViewModels()?.forEach { viewModel -> observe(viewModel.error, ::handleError) }
    }

    private fun handleError(error: ErrorModel?) {
        error?.let {

        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(MyContextWrapper.wrap(newBase))
    }
}