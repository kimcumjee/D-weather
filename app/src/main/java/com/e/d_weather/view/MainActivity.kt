package com.e.d_weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.e.d_weather.R
import com.e.d_weather.databinding.ActivityMainBinding
import com.e.d_weather.viewmodel.MainViewModel
/*
* - 엑티비티: 메인 엑티비티()
* - 담당자: 한승재
* - 수정 날짜: 2020.10.14
*/
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // 연결
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}