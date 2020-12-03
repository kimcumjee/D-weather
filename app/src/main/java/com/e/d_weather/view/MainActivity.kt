package com.e.d_weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.e.d_weather.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider
import com.e.d_weather.R
import com.e.d_weather.viewModel.MainViewModel

/*
* - 엑티비티: 메인 엑티비티()
* - 담당자: 한승재
* - 수정 날짜: 2020.10.14
*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // 연결
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.setWeatherTemp()
        viewModel.icon.observe(this) {
            binding.imageBinding = it
        }
    }
}