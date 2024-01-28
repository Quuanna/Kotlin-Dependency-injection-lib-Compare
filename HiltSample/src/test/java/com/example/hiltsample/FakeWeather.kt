package com.example.hiltsample

import com.example.hiltsample.weather.IWeather
import javax.inject.Inject

class FakeWeather @Inject constructor() : IWeather  {

    var fakeIsSunny = false // 建立屬性，讓外部可設定假的天氣要回傳晴天或雨天
    override fun isSunny(): Boolean {
        return fakeIsSunny
    }
}