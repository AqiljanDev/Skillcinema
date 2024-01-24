package com.example.skillcinema.domain.useCase

import android.util.Log
import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.repository.Repository
import javax.inject.Inject

class GetListCollectionsUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute(type: String): CollectionsFilms {
        Log.d("Mylog", "GetListCollectionsUseCase -> execute -- AFTER")
        val res = repository.getListCollections(type)
        Log.d("Mylog", "GetListCollectionsUseCase -> execute -- BEFORE - ${res.items[1].nameRu}")
        return res
    }
}