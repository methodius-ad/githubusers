package com.githubusers.data

import retrofit2.HttpException

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Failure(val exception: Throwable) : DataResult<Nothing>()
    data class Error(val code: Int, val message: String) : DataResult<Nothing>()
    data class Loading(val isShown: Boolean) : DataResult<Nothing>()
}

fun <T> DataResult<T>.getDataResult(): T? {
    return if (this is DataResult.Success) this.data else null
}

suspend fun <T> safeApiCall(call: suspend () -> DataResult<T>): DataResult<T> {
    return try {
        call()
    } catch (exception: Exception) {
        when (exception) {
            is HttpException -> handleHttpException(httpException = exception)
            else -> DataResult.Failure(exception = exception)
        }
    }
}

fun handleHttpException(httpException: HttpException): DataResult.Error {
    return DataResult.Error(
        code = httpException.code(),
        message = httpException.message ?: "",
    )
}


