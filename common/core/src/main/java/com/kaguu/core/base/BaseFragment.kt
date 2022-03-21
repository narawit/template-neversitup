package com.kaguu.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kaguu.core.model.ErrorModel
import com.kaguu.core.utils.extension.observe

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding!!

    abstract fun getViewModels(): List<BaseViewModel>?
    abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = getViewBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    open fun initView() {}
    open fun observer() {
        getViewModels()?.forEach { viewModel -> observe(viewModel.error, ::handleError) }
    }

    private fun handleError(error: ErrorModel?) {
        error?.let {
            TODO("Handle error data")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}