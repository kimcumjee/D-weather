package com.e.d_weather.network

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Retrofit : Activity() {
    private var loginInterface: WeatherInterface? = null
    lateinit var retrofit: Retrofit
    private var baseUrl: BaseUrl = BaseUrl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        loginInterface = retrofit.create(WeatherInterface::class.java)

    }
}

