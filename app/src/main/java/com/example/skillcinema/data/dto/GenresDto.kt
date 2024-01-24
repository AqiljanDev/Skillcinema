package com.example.skillcinema.data.dto

import com.example.skillcinema.domain.entities.Genres
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GenresDto(
    override val genre: String
) : Genres