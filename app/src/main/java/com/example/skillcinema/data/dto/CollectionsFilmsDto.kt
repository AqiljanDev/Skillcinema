package com.example.skillcinema.data.dto

import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.entities.Countries
import com.example.skillcinema.domain.entities.Genres
import com.example.skillcinema.domain.entities.ItemsCollections
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CollectionsFilmsDto(
    override val total: Int,
    override val totalPages: Int?,
    override val items: List<ItemsCollectionsDto>
) : CollectionsFilms

@JsonClass(generateAdapter = true)
class ItemsCollectionsDto(
    override val kinopoiskId: Int,
    override val imdbId: String?,
    override val nameRu: String?,
    override val nameEn: String?,
    override val nameOriginal: String?,
    override val countries: List<CountriesDto>,
    override val genres: List<GenresDto>,
    override val ratingKinopoisk: Float?,
    override val ratingImdb: Float?,
    override val year: Int?,
    override val type: String?,
    override val posterUrl: String?,
    override val posterUrlPreview: String?
) : ItemsCollections