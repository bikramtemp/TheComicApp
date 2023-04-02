package com.bikram.thecomicapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikram.thecomicapp.model.ComicRepository
import com.bikram.thecomicapp.model.response.ComicResponse
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(private val repository: ComicRepository = ComicRepository()) : ViewModel() {
    var currentId = 1
    var latestComicId = 1

    init {
        viewModelScope.launch {
            val comic = getComic()     // get most recent comic
            currentId = comic.num!!
            latestComicId = comic.num!!
            comicState.value = comic
        }
    }

    val comicState: MutableState<ComicResponse> = mutableStateOf(ComicResponse())

    // comicId will be null if fetching recent comic, otherwise an Int
    private suspend fun getComic(comicId: Int? = null): ComicResponse {
        return repository.getComic(comicId)
    }

    // called from all comic requests (first, last, random etc)
    private fun getGenericComic(comicId: Int) {
        viewModelScope.launch {
            val meals = getComic(comicId)
            comicState.value = meals
        }
    }

    fun getPrevComic() {
        if (currentId == 1)
            return

        getGenericComic(--currentId)
    }

    fun getNextComic() {
        if (currentId == latestComicId)
            return

        getGenericComic(++currentId)
    }

    fun getFirstComic() {
        currentId = 1
        getGenericComic(currentId)
    }

    fun getLastComic() {
        currentId = latestComicId
        getGenericComic(latestComicId)
    }

    fun getRandomComic() {
        currentId = Random().nextInt(latestComicId)
        getGenericComic(currentId)
    }

    fun getFormattedDate(day: String?, month: String?, year: String?): String {
        return if (day != null) {
            val date = "$day-$month-$year"
            val parser = SimpleDateFormat("dd-MM-yyyy")
            val formatter = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
            parser.parse(date)?.let { formatter.format(it) } ?: date
        } else
            ""
    }
}