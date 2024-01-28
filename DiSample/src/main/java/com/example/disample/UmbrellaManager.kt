package com.example.disample


class UmbrellaManager {

    fun totalPrice(quantity: Int, price: Int, weather: IWeather): Int {
        val isSunny = weather.isSunny() //取得是否晴天
        var total = quantity * price
        if (isSunny) {
            total = (total * 0.9).toInt() //晴天 -> 打9折
        }
        return total
    }
}