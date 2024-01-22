package com.example.automatedtestpractice.diSamplePractice

class Umbrella {

    //購買雨傘計價
    fun totalPrice(quantity: Int, price: Int, weather: IWeather): Int {
        val isSunny = weather.isSunny() //取得是否晴天
        var price = quantity * price
        if (isSunny) {
            price = (price * 0.9).toInt() //晴天 -> 打9折
        }
        return price
    }
}