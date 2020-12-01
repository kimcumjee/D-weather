package com.e.d_weather.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.e.d_weather.model.WeatherDataClass
import com.e.d_weather.network.BaseUrl
import com.e.d_weather.network.WeatherInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.text.*

/*
* - 엑티비티: MainViewModel()
* - 담당자: 한승재
* - 수정 날짜: 2020.10.14
*/
class MainViewModel : ViewModel() {
    var weatherTemp: String? = null
    lateinit var weatherDataClass: WeatherInterface
    lateinit var retrofit: Retrofit
    private var baseUrl: BaseUrl = BaseUrl()

    init {
        weatherTemp = setWeatherTemp()
    }

    private fun setWeatherTemp(): String {
        val appId = "09c8dfc52b7541d33c528d09a55e2c18"
        val locate = "DAEGU"
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        weatherDataClass = retrofit.create(WeatherInterface::class.java)
        weatherDataClass.getWeather(locate, appId, "metric")
            .enqueue(object : Callback<WeatherDataClass> {
                override fun onResponse(
                    call: Call<WeatherDataClass>,
                    response: Response<WeatherDataClass>
                ) {
                    WeatherDataClass.instance = response.body()!!
                    weatherTemp = String.format("%.1f", WeatherDataClass.instance!!.main!!.temp) + "°C"
                    Log.d("image", "image : $weatherTemp")
                }
                //서버와 연결 실패
                override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
                    Log.d("fa", "fa : ${t.message}")
                }
            })

        return weatherTemp!!
    }

    fun setImage() {

    }
}