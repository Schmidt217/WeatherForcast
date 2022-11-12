package dev.mikeschmidt.weatherforcast.network

import com.google.gson.internal.GsonBuildConfig
import dev.mikeschmidt.weatherforcast.BuildConfig
import dev.mikeschmidt.weatherforcast.model.Weather
import dev.mikeschmidt.weatherforcast.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = BuildConfig.API_KEY,
    ): Weather
}