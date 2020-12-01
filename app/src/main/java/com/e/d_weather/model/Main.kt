package com.e.d_weather.model

data class Main(
    var humidity : Int? = null,
    var pressure : Int? = null,
    //온도
    var temp : Float? = null,
    //최대 온도
    var temp_max : Float? = null,
    //최소 온도
    var temp_min : Float? = null
){}
