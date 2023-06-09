package com.bikram.thecomicapp.model

import com.bikram.thecomicapp.model.api.ComicWebService
import com.bikram.thecomicapp.model.response.ComicResponse

class ComicRepository(private val webService: ComicWebService = ComicWebService()) {
    constructor(webService: ComicWebService.ComicApi) : this()

    suspend fun getComic(comicId: Int?): ComicResponse {
        return webService.getComic(comicId)
    }
}