package com.e.d_weather.network

import android.app.Application
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Retrofit application 으로 동작
class RetrofitApplication : Application(){
    lateinit var weatherDataClass: WeatherInterface
    lateinit var retrofit: Retrofit
    private var baseUrl : BaseUrl = BaseUrl()

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        val httpClient = OkHttpClient.Builder()
        httpClient.addNetworkInterceptor(StethoInterceptor())
        val client = httpClient.build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.Url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        weatherDataClass = retrofit.create(WeatherInterface::class.java)
    }
}

