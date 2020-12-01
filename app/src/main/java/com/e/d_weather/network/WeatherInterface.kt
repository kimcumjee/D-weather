package com.e.d_weather.network

import com.e.d_weather.model.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET("/data/2.5/weather?")
    fun getWeather(
        @Query("q") q : String,
        @Query("appid") appid : String,
        @Query("units") units : String
    ): Call<WeatherDataClass>

}