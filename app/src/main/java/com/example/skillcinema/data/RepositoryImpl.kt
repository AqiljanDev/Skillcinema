package com.example.skillcinema.data

import android.util.Log
import com.example.skillcinema.data.api.retrofit
import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.repository.Repository

class RepositoryImpl : Repository {
    override suspend fun getListPremier(): CollectionsFilms {
        Log.d("Mylog", "REPOSITORY PREMIER")
        return retrofit.toListPremier()
    }

    override suspend fun getListCollections(type: String): CollectionsFilms {
        Log.d("Mylog", "REPOSITORY COLLECTIONS FILMS -- AFTER")
        val res = retrofit.toListCollections(type)
        Log.d("Mylog", "REPOSITORY COLLECTIONS FILMS -- BEFORE")
        return res
    }

    override suspend fun getListFilmsFilter(countries: Int, genres: Int): CollectionsFilms {
        return retrofit.toListFilmsFilters(countries, genres)
    }

    override suspend fun getListFilmsFilter(type: String): CollectionsFilms {
        return retrofit.toListFilmsFilters(type)
    }
}