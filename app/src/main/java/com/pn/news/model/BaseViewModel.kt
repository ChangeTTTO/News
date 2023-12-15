package com.pn.news.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * 所有ViewModel，主要是显示公共逻辑
 * 例如：提示相关LiveData
 */
open class BaseViewModel : ViewModel() {
    /*protected val viewModel: BaseViewModel
        get() = this

    *//**
     * 协程异常处理器
     *//*
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
//        Log.e(TAG, "coroutineExceptionHandler ", exception)
        exception.printStackTrace()
        _exception.value = exception
    }

    *//**
     * 本地提示
     *//*
    protected val _tip = MutableLiveData<Int>()
    val tip: LiveData<Int> = _tip

    *//**
     * 异常
     *//*
    protected val _exception = MutableLiveData<Throwable>()
    val exception: LiveData<Throwable> = _exception

    *//**
     * 网络响应业务失败
     *//*
    val _response = MutableLiveData<BaseResponse>()
    val response: LiveData<BaseResponse> = _response

    *//**
     * 是否显示对话框
     *//*
    protected val _loading = MutableLiveData<String>()
    val loading: LiveData<String> = _loading

    *//**
     * 关闭界面
     *//*
    protected val _finishPage = MutableLiveData<Long>()
    val finishPage: LiveData<Long> = _finishPage

    fun finish() {
        _finishPage.value = System.currentTimeMillis()
    }

    companion object {
        const val TAG = "BaseViewModel"
    }*/
}