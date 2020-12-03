package com.e.d_weather.`object`

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.e.d_weather.R

object ImageBinding {
    @JvmStatic
    @BindingAdapter("image")
    fun setWeatherImage(imageView: ImageView, icon: String?) {
        if (icon == "01d") {
            imageView.setImageResource(R.drawable.sun)
        } else if (icon == "01n") {
            imageView.setImageResource(R.drawable.night)
        } else if (icon == "02d") {
            imageView.setImageResource(R.drawable.sun_cloud)
        } else if (icon == "02n") {
            imageView.setImageResource(R.drawable.night_cloud)
        } else if (icon == "03d" || icon == "03n" || icon == "04d" || icon == "04n") {
            imageView.setImageResource(R.drawable.cloud)
        } else if (icon == "09d" || icon == "09n" || icon == "10n" || icon == "10d") {
            imageView.setImageResource(R.drawable.rain)
        } else if (icon == "11d" || icon == "11n") {
            imageView.setImageResource(R.drawable.thunder)
        } else if (icon == "13d" || icon == "13n") {
            imageView.setImageResource(R.drawable.snow)
        } else if (icon == "50d" || icon == "50n") {
            imageView.setImageResource(R.drawable.mist)
        }
    }
}