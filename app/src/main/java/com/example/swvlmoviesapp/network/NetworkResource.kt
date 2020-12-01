package com.example.swvlmoviesapp.network

import com.example.swvlmoviesapp.utils.Constants

/**
 * Network Resource data class for Retrofit.
 *
 */
data class NetworkResource<out T>(
    val status: Constants.Status,
    val data: T?,
    val message: String?,
    val responseCode: Int
) {

    companion object {
        /**
         * Handle success response from network.
         * @param data
         * @param responseCode
         */
        fun <T> success(data: T?, responseCode: Int): NetworkResource<T> {
            return NetworkResource(
                Constants.Status.SUCCESS,
                data,
                null,
                responseCode
            )
        }

        /**
         * Handle error response from network.
         * @param msg
         * @param data
         * @param responseCode
         */
        fun <T> error(msg: String, data: T?, responseCode: Int): NetworkResource<T> {
            return NetworkResource(
                Constants.Status.ERROR,
                data,
                msg,
                responseCode
            )
        }

        /**
         * Handle no internet connection exception while making a network call.
         * @param msg
         * @param data
         * @param responseCode
         */
        fun <T> noInternetConnection(msg: String, data: T?, responseCode: Int): NetworkResource<T> {
            return NetworkResource(
                Constants.Status.NO_INTERNET_CONNECTION,
                data,
                msg,
                responseCode
            )
        }
    }
}
