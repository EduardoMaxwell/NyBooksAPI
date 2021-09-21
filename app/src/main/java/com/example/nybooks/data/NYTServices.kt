package com.example.nybooks.data

import com.example.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query(value = "api-key") apiKey: String = "61nKxdHIUfAaPfVImQu3XTNGgk8cA2al",
        @Query(value = "list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}