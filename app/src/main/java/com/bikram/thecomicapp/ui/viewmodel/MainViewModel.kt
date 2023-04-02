package com.bikram.thecomicapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikram.thecomicapp.model.ComicRepository
import com.bikram.thecomicapp.model.response.ComicResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

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