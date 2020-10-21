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

        (application as RetrofitApplication).retrofit.create(WeatherInterface::class.java)
            .getWeather()

            .enqueue(object : Callback<WeatherDataClass> {

                override fun onResponse(
                    call: Call<EmailLoginBody>,
                    response: Response<EmailLoginBody>

                ) {
                    //다음 화면으로 이동
                    val intent = Intent(context, MainActivity::class.java)

                    
                    //통신성공
                    if (response.code() == 200) {

                        //서버로부터 받은 정보들을 EmailLoginBody 변수에 담아준다
                        EmailLoginBody.instance = response.body()
                        getUser.getUserData(getApplication, context)

                    }
                    //통신 실패
                    else if (response.code() == 401) {
                        Log.d("error", "error = " + response.errorBody())

                    }

                }

                //서버와 연결 실패
                override fun onFailure(call: Call<EmailLoginBody>, t: Throwable) {
                    //LoginDialog 를 호출하여 서버와의 연결 실패를 dialog 로 띄운다
                    loginDialog.connectionFail(context, sweetAlertDialog)
                }


            })
    }
}
}