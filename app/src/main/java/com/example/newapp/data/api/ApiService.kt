package com.example.newapp.data.api

import com.example.newapp.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts() : Response<List<Post>>
}