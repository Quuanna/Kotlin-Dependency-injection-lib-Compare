package com.example.koinsample.manager

import com.example.koinsample.weather.IWeather


class UmbrellaManager(private val weather: IWeather){

    //購買雨傘計價
    fun totalPrice(quantity: Int, price: Int): Int {
        var total = quantity * price
        if (weather.isSunny()) {
            total = (total * 0.9).toInt() //晴天 -> 打9折
        }
        return total
    }
}