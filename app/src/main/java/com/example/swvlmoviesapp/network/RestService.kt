package com.example.swvlmoviesapp.network

import com.example.swvlmoviesapp.BuildConfig
import com.example.swvlmoviesapp.utils.Constants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit Singleton class fot API services
 */
object RestService {
    private lateinit var restAPIs: RestAPIs

    /**
     * Get RestAPI client
     * @return RestAPIs
     */
    fun getClient(): RestAPIs {
        if (!this::restAPIs.isInitialized) {
            /// logging interceptor for displaying logs in LogCat.
            val logInterceptor = HttpLoggingInterceptor()
            /// enabling logs only for debug versions
            if (BuildConfig.DEBUG) {
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }
            /// creating OkHttpClient for Retrofit.
            val client = OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .addInterceptor(ConnectivityInterceptor())
                .build()
            /// creating retrofit instance.
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(Constants.RestConstants.FLICKR_BASE_URL)
                .client(client)
                .build()

            restAPIs = retrofit.create(RestAPIs::class.java)
        }
        return restAPIs
    }

}