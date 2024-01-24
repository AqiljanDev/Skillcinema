package com.example.skillcinema.domain.repository

import com.example.skillcinema.domain.entities.CollectionsFilms

interface Repository {

    suspend fun getListPremier(): CollectionsFilms

    suspend fun getListCollections(type: String): CollectionsFilms

    suspend fun getListFilmsFilter(countries: Int, genres: Int): CollectionsFilms
    suspend fun getListFilmsFilter(type: String): CollectionsFilms

}