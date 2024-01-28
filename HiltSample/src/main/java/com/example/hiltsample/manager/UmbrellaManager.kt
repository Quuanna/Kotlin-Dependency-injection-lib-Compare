package com.example.hiltsample.manager

import com.example.hiltsample.weather.IWeather
import javax.inject.Inject


class UmbrellaManager @Inject constructor(private val weather: IWeather) {

    //購買雨傘計價
    fun totalPrice(quantity: Int, price: Int): Int {
        var total = quantity * price
        if (weather.isSunny()) {
            total = (total * 0.9).toInt() //晴天 -> 打9折
        }
        return total
    }
}