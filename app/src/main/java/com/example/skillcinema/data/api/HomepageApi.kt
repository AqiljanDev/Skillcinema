package com.example.skillcinema.data.api

import com.example.skillcinema.data.dto.CollectionsFilmsDto
import com.example.skillcinema.domain.entities.Countries
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

val retrofit = Retrofit.Builder()
    .baseUrl("https://kinopoiskapiunofficial.tech/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(HomepageApi::class.java)

private const val API_KEY = "cb530209-37f2-4808-a634-6aca999d6326"
interface HomepageApi {

    @Headers("X-API-KEY: $API_KEY")
    @GET("api/v2.2/films/collections")
    suspend fun toListCollections(@Query("type") type: String): CollectionsFilmsDto

    @Headers("X-API-KEY: $API_KEY")
    @GET("api/v2.2/films/premieres?year=2024&month=JANUARY")
    suspend fun toListPremier(): CollectionsFilmsDto

    @Headers("X-API-KEY: $API_KEY")
    @GET("api/v2.2/films")
    suspend fun toListFilmsFilters(@Query("countries") countries: Int, @Query("genres") genres: Int): CollectionsFilmsDto

    @Headers("X-API-KEY: $API_KEY")
    @GET("api/v2.2/films")
    suspend fun toListFilmsFilters(@Query("type") type: String): CollectionsFilmsDto
}