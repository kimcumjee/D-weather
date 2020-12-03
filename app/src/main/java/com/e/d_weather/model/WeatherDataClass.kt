package com.e.d_weather.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDataClass(

    var main: Main? = null,
    @SerializedName("weather")
    //날씨정보를 담아주는 변수
    var weatherList: ArrayList<Weather>? = null

) {
    companion object {
        var instance: WeatherDataClass? = null
    }
}

