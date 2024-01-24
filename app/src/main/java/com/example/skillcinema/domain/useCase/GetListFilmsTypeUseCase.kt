package com.example.skillcinema.domain.useCase

import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.repository.Repository
import javax.inject.Inject

class GetListFilmsTypeUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun execute(type: String): CollectionsFilms {
        return repository.getListFilmsFilter(type)
    }
}