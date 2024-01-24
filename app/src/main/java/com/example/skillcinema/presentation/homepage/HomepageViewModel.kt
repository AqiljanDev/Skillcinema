package com.example.skillcinema.presentation.homepage

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.domain.useCase.GetListCollectionsUseCase
import com.example.skillcinema.domain.useCase.GetListFilmsFilterUseCase
import com.example.skillcinema.domain.useCase.GetListFilmsTypeUseCase
import com.example.skillcinema.domain.useCase.GetListPremieresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val getListPremieresUseCase: GetListPremieresUseCase,
    private val getListCollectionsUseCase: GetListCollectionsUseCase,
    private val getListFilmsFilterUseCase: GetListFilmsFilterUseCase,
    private val getListFilmsTypeUseCase: GetListFilmsTypeUseCase
) : ViewModel() {

    private val _listFilms: MutableStateFlow<HashMap<String, CollectionsFilms>> = MutableStateFlow( hashMapOf() )
    val listFilms = _listFilms.asStateFlow()

    private val _listPremieres: MutableSharedFlow<CollectionsFilms> = MutableSharedFlow()
    val listPremieres = _listPremieres.asSharedFlow()

    private val _listPopular = MutableSharedFlow<CollectionsFilms>()
    val listPopular = _listPopular.asSharedFlow()

    private val _listFilmsFilter = MutableSharedFlow<CollectionsFilms>()
    val listFilmsFilter = _listFilmsFilter.asSharedFlow()

    fun replenishPremier(name: String) {
        Log.d("Mylog", "start replenish")

        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Mylog", "start replenish -> launch")
            kotlin.runCatching {
                getListPremieresUseCase.execute()
            }.fold(
                onSuccess = {
                    Log.d("Mylog", "IT = ${it.items[0].nameRu}")
                    _listFilms.emit(hashMapOf(Pair(name, it))) },
                onFailure = { Log.d("Mylog", "Exception premier execute") }
            )

        }
    }

    fun replenishCollections(type: CollectionsType, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getListCollectionsUseCase.execute(type.toString())
            }.fold(
                onSuccess = {
                    _listFilms.emit(hashMapOf(Pair(name, it))) },
                onFailure = { Log.d("Mylog", "Exception collections execute") }

            )
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun replenishFilmsFilter() {
        viewModelScope.launch(Dispatchers.IO) {
            repeat(2) {
                val countriesId = Random.nextInt(1..33)
                val genresId = Random.nextInt(1..33)

                kotlin.runCatching {
                    getListFilmsFilterUseCase.execute(countriesId, genresId)
                }.fold(
                    onSuccess = {
                        _listFilms.emit(
                            hashMapOf(Pair(
                                it.items[0].genres[0].genre.replaceFirstChar {char -> char.uppercase() } +
                                        " " + it.items[0].countries[0].country, it
                            ))
                        )},
                    onFailure = { Log.d("Mylog", "Exception films filter execute") }
                )
            }
        }
    }

    fun replenishSeries(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                getListFilmsTypeUseCase.execute("TV_SERIES")
            }.fold(
                onSuccess = { _listFilms.emit(hashMapOf( Pair(name, it)) ) },
                onFailure = { Log.d("Mylog", "Exception films type execute") }
            )
        }
    }
}

enum class CollectionsType {
    TOP_POPULAR_ALL,
    TOP_250_MOVIES
}
