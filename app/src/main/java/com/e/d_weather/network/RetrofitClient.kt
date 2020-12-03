package com.e.d_weather.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient{
    companion object {

        fun getInstance(): WeatherInterface {
            val baseUrl = BaseUrl()
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


