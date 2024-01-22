package com.example.automatedtestpractice

import com.example.automatedtestpractice.diSamplePractice.Umbrella
import com.example.automatedtestpractice.koinSamplePractice.UmbrellaForKoin
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UmbrellaTest {

    private lateinit var umbrella: Umbrella
    private lateinit var stubWeather: StubWeather // //建一個假的Weather

    @Before
    fun setup() {
        umbrella = Umbrella()
        stubWeather = StubWeather()
    }


//    @Test
//    fun totalPrice() {
//        val umbrella = Umbrella()
//        //問題：不曉得是晴天還雨天
//        val actual = umbrella.totalPrice(3,100)
//        val expected = 270
//        Assert.assertEquals(expected, actual)
//    }


    @Test
    fun totalPrice_SunnyDay() {
        stubWeather.fakeIsSunny = true  //晴天的測試
        val actual = umbrella.totalPrice(3, 100, stubWeather)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay() {
        stubWeather.fakeIsSunny = false //雨天的測試
        val actual = umbrella.totalPrice(3, 100, stubWeather)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_SunnyDay_use_koin() {
        stubWeather.fakeIsSunny = true  //晴天的測試
        val umbrella = UmbrellaForKoin(stubWeather)
        val actual = umbrella.totalPrice(3, 100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun totalPrice_rainingDay_use_koin() {
        stubWeather.fakeIsSunny = false //雨天的測試
        val umbrella = UmbrellaForKoin(stubWeather)
        val actual = umbrella.totalPrice(3, 100)
        val expected = 300
        Assert.assertEquals(expected, actual)
    }
}