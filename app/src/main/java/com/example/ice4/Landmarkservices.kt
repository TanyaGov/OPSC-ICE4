package com.example.ice4

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LandmarkService {
    @GET("nearbysearch/json")
    fun getNearbyLandmarks(
        @Query("location") location: String,    // User's current location in lat,lng
        @Query("radius") radius: Int,           // Search radius in meters
        @Query("type") type: String,            // Type of places (e.g., "tourist_attraction")
        @Query("key") apiKey: String            // Google API Key
    ): Call<LandmarkResponse>
}

data class LandmarkResponse(
    val results: List<Landmark>
)

data class Landmark(
    val name: String,
    val geometry: Geometry
)

data class Geometry(
    val location: Location
)

data class Location(
    val lat: Double,
    val lng: Double
)
