package com.example.myip.restApi

import com.example.myip.entities.UserResponce
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {

    @GET("/awstest-service/")
    suspend fun getUser(): UserResponce

    companion object {
        private const val BASE_URL =
            "http://awstest-balancer-1233234915.us-east-2.elb.amazonaws.com/"

        fun get(): UserApi = Retrofit.Builder().baseUrl(BASE_URL)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }).build()
            )
            .build().create(UserApi::class.java)
    }
}


