package dev.mikeschmidt.weatherforcast.repository

import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import dev.mikeschmidt.weatherforcast.data.DataOrException
import dev.mikeschmidt.weatherforcast.model.Weather
import dev.mikeschmidt.weatherforcast.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery)
        }catch (e: Exception) {
            Log.d("REX", "getWeatherFromREPO: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "weather response: $response")
        return DataOrException(data = response)
    }
}