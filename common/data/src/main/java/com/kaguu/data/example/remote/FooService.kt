package com.kaguu.data.example.remote

import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FooService {
    @GET("foo/{id}")
    suspend fun getFoo(@Path("id") id: String): Response

    @POST("foo")
    suspend fun postFoo(
        @Body id: String
    ): Response
}
