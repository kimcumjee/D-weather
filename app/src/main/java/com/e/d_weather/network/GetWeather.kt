package com.e.d_weather.network

import android.app.Application
import android.content.Intent

import android.util.Log
import com.e.d_weather.view.MainActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetWeather {
    internal fun getWeather(
        application: Application
    ) {
        val appId = "09c8dfc52b7541d33c528d09a55e2c18"
        val locate = "DAEGU"
        (application as RetrofitApplication).retrofit.create(WeatherInterface::class.java)
            .getWeather(locate,appId)
            .enqueue(object : Callback<WeatherDataClass> {
                override fun onResponse(
                    call: Call<WeatherDataClass>,
                    response: Response<WeatherDataClass>
                ) {
                    //통신성공
                    if (response.code() == 200) {
                        Log.d("success","success : ${response.body()}")
                    }
                    //통신 실패
                    else if (response.code() == 401) {
                        Log.d("error", "error = " + response.errorBody())
                    }
                }
                //서버와 연결 실패
                override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
                    Log.d("fa","fa")
                }
            })
    }
}