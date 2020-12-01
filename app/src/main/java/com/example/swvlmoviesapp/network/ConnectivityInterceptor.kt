package com.example.swvlmoviesapp.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.swvlmoviesapp.SWVLMoviesApp
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Connectivity Interceptor class for Retrofit.
 */
open class ConnectivityInterceptor : Interceptor {

    private val isConnected: Boolean
        get() {
            return isInternetAvailable(SWVLMoviesApp.getInstance())
        }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        if (!isConnected) {
            throw NoNetworkException()
        }
        return chain.proceed(originalRequest)
    }

    class NoNetworkException internal constructor() : IOException()

    companion object {
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCapabilities =
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    connectivityManager.activeNetwork ?: return false
                } else {
                    return false
                }
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    }
}
