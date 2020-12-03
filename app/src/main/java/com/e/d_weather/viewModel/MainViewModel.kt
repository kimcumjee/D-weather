package com.e.d_weather.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.d_weather.model.Weather
import com.e.d_weather.model.WeatherDataClass
import com.e.d_weather.network.BaseUrl
import com.e.d_weather.network.WeatherInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.text.*

/*
* - 엑티비티: MainViewModel()
* - 담당자: 한승재
* - 수정 날짜: 2020.10.14
*/
class MainViewModel : ViewModel() {
    var weatherTemp = ObservableField<String>()

    var icon = MutableLiveData<Weather>();

    var weatherIcon: String = ""

    lateinit var weatherDataClass: WeatherInterface
    var retrofit = com.e.d_weather.network.RetrofitClient()
    private var baseUrl: BaseUrl = BaseUrl()
    private val appId = "09c8dfc52b7541d33c528d09a55e2c18"
    private val locate = "DAEGU"
    var api = com.e.d_weather.network.RetrofitClient.getInstance()
    fun setWeatherTemp() {
        api.getWeather(locate, appId, "metric")
            .enqueue(object : Callback<WeatherDataClass> {
                override fun onResponse(
                    call: Call<WeatherDataClass>,
                    response: Response<WeatherDataClass>
                ) {
                    Log.d("씨발련아", "씨발련아")
                    WeatherDataClass.instance = response.body()
                    weatherTemp.set(String.format("%.1f", response.body()?.main?.temp) + "°C 입니다")
                    weatherIcon = response.body()?.weatherList!![0].icon!!
                    WeatherDataClass.instance?.weatherList?.get(0)?.let {
                        icon.value = it
                    }
                }
                //서버와 연결 실패
                override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
                    Log.d("fa", "fa : ${t.message}")
                }
            })
    }
}