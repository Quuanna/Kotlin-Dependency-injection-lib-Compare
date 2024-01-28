package com.example.hiltsample

import com.example.hiltsample.di.WeatherModule
import com.example.hiltsample.weather.IWeather
import dagger.Binds
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.testing.TestInstallIn
import com.example.hiltsample.FakeWeather


// Overrides WeatherModule in android tests
@TestInstallIn(
    components=[ActivityComponent::class],
    replaces=[WeatherModule::class]
)
abstract class TestWeatherModule {

    @Binds
    abstract fun bind(weather: FakeWeather): IWeather

}