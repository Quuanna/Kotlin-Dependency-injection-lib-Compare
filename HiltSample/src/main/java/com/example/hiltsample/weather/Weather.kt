package com.example.hiltsample.weather
import javax.inject.Inject


// 建構子加上@Inject後，創建 abstract class 用來告訴Hilt要怎麼得到實例，透過 @Binds 註解將實例回傳
class Weather @Inject constructor() : IWeather {
    override fun isSunny(): Boolean {
        return false
    }
}