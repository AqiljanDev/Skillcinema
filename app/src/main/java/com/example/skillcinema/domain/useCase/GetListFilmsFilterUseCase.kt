package com.example.skillcinema.domain.useCase

import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.repository.Repository
import javax.inject.Inject

class GetListFilmsFilterUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun execute(countries: Int, genres: Int): CollectionsFilms {
        return repository.getListFilmsFilter(countries, genres)
    }
}