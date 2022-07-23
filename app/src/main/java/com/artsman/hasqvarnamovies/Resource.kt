package com.artsman.hasqvarnamovies

data class Resource <T>(val data: T?, val status : Status, val error: Error?)

enum class Status{
    Success, UnSuccessful, Failure
}
data class Error(val message: String)

fun <T> Resource<T>.unsuccessful(error: Error?=null)= this.copy(data = null, status = Status.UnSuccessful)
fun <T> Resource<T>.successful(data: T)= this.copy(data = data, status = Status.Success)
fun <T> Resource<T>.isSuccessful() = this.status == Status.Success


fun <T> successful(data: T)= Resource(data = data, status = Status.Success, null)
fun <T> unSuccessful(error: Error?= null)= Resource<T>(data = null, status = Status.UnSuccessful, error)
fun <T> failure(error: Error?= null)= Resource<T>(data = null, status = Status.Failure, error)