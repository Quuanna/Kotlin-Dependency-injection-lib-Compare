package com.example.hiltsample.di

import com.example.hiltsample.weather.IWeather
import com.example.hiltsample.weather.Weather
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

// 在不同的Activity之間使用不同的實體，則在@InstallIn中傳入ActivityComponent即可
@Module
@InstallIn(ActivityComponent::class)
abstract class WeatherModule {
    @Binds
    abstract fun bind(weather: Weather): IWeather // 透過 @Binds 註解將實例回傳注入
}