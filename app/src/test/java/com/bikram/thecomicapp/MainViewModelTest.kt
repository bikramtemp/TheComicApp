package com.bikram.thecomicapp

import com.bikram.thecomicapp.model.ComicRepository
import com.bikram.thecomicapp.model.api.ComicWebService
import com.bikram.thecomicapp.model.response.ComicResponse
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class MainViewModelTest {
    @get:Rule
    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: ComicWebService.ComicApi
    private lateinit var comicsRepository: ComicRepository

    @Before
    fun startUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        service = Retrofit.Builder()
            .baseUrl("https://xkcd.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ComicWebService.ComicApi::class.java)

        //Create repository with the mocked web server
        comicsRepository = ComicRepository(service)
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `service_getLatestComic and check latest is current year`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(apiComic))
        mockWebServer.enqueue(response)

        runBlocking {
            val actual = service.getLatestComic()
            val expected = apiComic

            assertThat(actual.year).isEqualTo(expected.year)
        }
    }

    @Test
    fun `service_getLatestComic and check response returned`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(apiComic))
        mockWebServer.enqueue(response)

        runBlocking {
            val actual = service.getLatestComic()
            val expected = apiComic

            assertThat(actual).isNotEqualTo(expected)
        }
    }

    //TODO add cases for diff http responses - 200,400 etc
    //TODO add cases with mock json
}

private val apiComic = ComicResponse(
    alt = "Desc",
    day = "04",
    img = "img",
    link = "link",
    month = "04",
    news = "news",
    num = 12,
    title = "title",
    transcript = "transcript",
    year = "2023",
    safeTitle = "st"
)