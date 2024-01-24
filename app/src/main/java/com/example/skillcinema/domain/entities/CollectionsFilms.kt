package com.example.skillcinema.domain.entities

interface CollectionsFilms {
    val total: Int
    val totalPages: Int?
    val items: List<ItemsCollections>
}

interface ItemsCollections {
    val kinopoiskId: Int
    val imdbId: String?
    val nameRu: String?
    val nameEn: String?
    val nameOriginal: String?
    val countries: List<Countries>
    val genres: List<Genres>

    val ratingKinopoisk: Float?
    val ratingImdb: Float?
    val year: Int?
    val type: String?
    val posterUrl: String?
    val posterUrlPreview: String?
}