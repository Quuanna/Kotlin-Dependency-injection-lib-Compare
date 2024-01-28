package com.example.koinsample.di

import com.example.koinsample.weather.IWeather
import com.example.koinsample.manager.UmbrellaManager
import com.example.koinsample.weather.Weather
import org.koin.dsl.module

val weatherModule = module {

    factory<IWeather> {
        Weather()
    }

    factory {
        UmbrellaManager(get())
    }

}


