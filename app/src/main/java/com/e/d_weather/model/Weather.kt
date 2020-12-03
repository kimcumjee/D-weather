package com.e.d_weather.model

data class Weather(
    var description: String? = null,
    var icon: String? = null,
    var id: Int? = null,
    var main: String? = null
) {}