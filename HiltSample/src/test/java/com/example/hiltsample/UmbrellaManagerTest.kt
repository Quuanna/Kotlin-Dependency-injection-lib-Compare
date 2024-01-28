package com.example.hiltsample

import com.example.hiltsample.manager.UmbrellaManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UmbrellaManagerTest {

    private lateinit var umbrellaManager: UmbrellaManager
    private lateinit var stubWeather: FakeWeather // //建一個假的Weather

    @Before
    fun setup() {
        stubWeather = FakeWeather()
        umbrellaManager = UmbrellaManager(stubWeather)
    }

    @Test
    fun totalPrice_sunnyDay(){
        //設定這個假的Weather永遠回傳目前天氣為晴天
        stubWeather.fakeIsSunny = true

        //晴天的測試
        val actual = umbrellaManager.totalPrice(3, 100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay(){
        //設定這個假的Weather永遠回傳目前天氣為雨天
        stubWeather.fakeIsSunny = false

        //雨天的測試
        val actual = umbrellaManager.totalPrice(3, 100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }
}