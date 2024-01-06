package dev.rustybite.rustysport.utils

sealed class RustySportsState<T>(data: T? = null, message: String? = null) {
    data class Success<T>(val data: T) : RustySportsState<T>(data = data)
    data class Failure<T>(val message: String) : RustySportsState<T>(message = message)
    class Loading<T> : RustySportsState<T>()
}