package com.kaguu.core.model

data class ErrorModel(
    val code: Int,
    val message: String?
){
    companion object{
        const val MESSAGE = 0
        const val THROWABLE = 1
    }
}