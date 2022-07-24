package com.artsman.hasqvarnamovies.framework.network

import com.artsman.hasqvarnamovies.Error
import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.Status
import io.ktor.client.plugins.*
import kotlin.Exception

suspend inline fun <reified T> execute(serviceCall : ()->T): Resource<T>{
    return try {
        val result = serviceCall()
        Resource(data = result, status = Status.Success, error = null)
    }catch (e: ClientRequestException){
        Resource(null, Status.UnSuccessful, com.artsman.hasqvarnamovies.Error(e.message?: ""))
    }catch (e: Exception){
        Resource(null, Status.UnSuccessful, com.artsman.hasqvarnamovies.Error(e.message?: ""))
    }
}