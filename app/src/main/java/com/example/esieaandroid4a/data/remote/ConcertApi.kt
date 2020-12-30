package com.example.esieaandroid4a.data.remote

import com.example.esieaandroid4a.data.remote.entity.RestConcertResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ConcertApi {
    @GET
    fun getConcertResponse(@Url url: String?): Call<RestConcertResponse>
}