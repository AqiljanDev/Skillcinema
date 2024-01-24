package com.example.skillcinema.presentation.entities

import com.example.skillcinema.domain.entities.CollectionsFilms

data class ParentItemDataClass(
    val title: String,
    val allVisible: Boolean,
    val list: CollectionsFilms
)
