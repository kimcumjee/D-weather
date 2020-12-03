package com.e.d_weather.network

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient : Application() {
    companion object {

        fun getInstance(): WeatherInterface {
            val baseUrl : BaseUrl = BaseUrl()
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(baseUrl.Url)
                .addConverterFactory(GsonConverterFactory.create())

            val builder = OkHttpClient.Builder()
            builder.addNetworkInterceptor(StethoInterceptor())
            val client = builder.build()
            retrofitBuilder.client(client)

            val retrofit = retrofitBuilder.build()
            return retrofit.create(WeatherInterface::class.java)

        }
    }
}


