package com.bikram.thecomicapp.model.api

import com.bikram.thecomicapp.model.response.ComicResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class ComicWebService {
    private lateinit var api: ComicApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://xkcd.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ComicApi::class.java)
    }

    suspend fun getComic(comicId: Int): ComicResponse {
        return api.getComic(comicId)
    }

    interface ComicApi {
        @GET("{id}/info.0.json")
        suspend fun getComic(@Path("id") comicId: Int): ComicResponse
    }
}