package com.bikram.thecomicapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikram.thecomicapp.model.ComicRepository
import com.bikram.thecomicapp.model.response.ComicResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ComicRepository = ComicRepository()) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val comic = getComic(1)     // fetch 1st comic for test
            comicState.value = comic
        }
    }

    val comicState: MutableState<ComicResponse> = mutableStateOf(ComicResponse())

    private suspend fun getComic(comicId: Int): ComicResponse {
        return repository.getComic(comicId)
    }
}