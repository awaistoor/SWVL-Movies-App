package com.example.swvlmoviesapp.network


import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Network response handler class for Retrofit.
 */
open class NetworkResponseHandler {
    fun <T : Any> handleSuccess(data: T?, responseCode: Int): NetworkResource<T> {
        return NetworkResource.success(data, responseCode)
    }

    /**
     * Handle HTTP exceptions
     * @param e
     */
    fun <T : Any> handleException(e: Exception): NetworkResource<T> {
        return when (e) {
            is HttpException -> NetworkResource.error(e.localizedMessage ?: "", null, -5)
            is ConnectivityInterceptor.NoNetworkException -> NetworkResource.noInternetConnection(
                "No internet connection",
                null,
                -1
            )
            is UnknownHostException -> NetworkResource.noInternetConnection(
                "Unknown host",
                null,
                -2
            )
            is ConnectException -> NetworkResource.noInternetConnection(
                "No internet connection",
                null,
                -3
            )
            is SocketTimeoutException -> NetworkResource.error(
                "Socket timeout",
                null,
                -4
            )
            else -> NetworkResource.error("Something went wrong", null, -1)
        }
    }

    /**
     * Handle API exceptions with status code.
     * @param statusCode
     */
    fun <T : Any> handleException(statusCode: Int): NetworkResource<T> {
        return NetworkResource.error("Exception occurred", null, statusCode)
    }
}
