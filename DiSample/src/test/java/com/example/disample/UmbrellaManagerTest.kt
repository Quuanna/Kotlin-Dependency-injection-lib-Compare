package com.example.disample

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UmbrellaManagerTest {

    private lateinit var umbrellaManager: UmbrellaManager
    private lateinit var stubWeather: FakeWeather // //建一個假的Weather

    @Before
    fun setup() {
        umbrellaManager = UmbrellaManager()
        stubWeather = FakeWeather()
    }

    @Test
    fun totalPrice_SunnyDay() {
        stubWeather.fakeIsSunny = true  //晴天的測試
        val actual = umbrellaManager.totalPrice(3, 100, stubWeather)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay() {
        stubWeather.fakeIsSunny = false //雨天的測試
        val actual = umbrellaManager.totalPrice(3, 100, stubWeather)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }
}