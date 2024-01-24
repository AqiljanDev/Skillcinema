package com.example.skillcinema.data.dto

import com.example.skillcinema.domain.entities.Countries
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CountriesDto(
    override val country: String
) : Countries