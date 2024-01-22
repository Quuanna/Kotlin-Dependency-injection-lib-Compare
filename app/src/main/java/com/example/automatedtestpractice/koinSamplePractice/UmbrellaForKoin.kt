package com.example.automatedtestpractice.koinSamplePractice


class UmbrellaForKoin(val weather: IWeather){

    var isSunny: Boolean = false //外部調整是否晴天

    //購買雨傘計價
    fun totalPrice(quantity: Int, price: Int): Int {
        var total = quantity * price
        if (weather.isSunny(isSunny)) {
            total = (price * 0.9).toInt() //晴天 -> 打9折
        }
        return total
    }
}