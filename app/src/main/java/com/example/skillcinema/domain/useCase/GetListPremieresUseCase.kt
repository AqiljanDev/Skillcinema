package com.example.skillcinema.domain.useCase

import android.util.Log
import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.repository.Repository
import javax.inject.Inject

class GetListPremieresUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun execute(): CollectionsFilms {
        Log.d("Mylog", "GetListPremieresUseCase -> execute")
        return repository.getListPremier()
    }
}