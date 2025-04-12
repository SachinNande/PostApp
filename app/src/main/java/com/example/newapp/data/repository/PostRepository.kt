package com.example.newapp.data.repository

import com.example.newapp.data.api.ApiService
import com.example.newapp.data.model.Post
import javax.inject.Inject

class PostRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getPost(): List<Post> {
        return try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}