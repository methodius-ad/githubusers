package com.githubusers.data.api

import com.githubusers.data.model.response.UserResponse
import com.githubusers.data.model.response.UserDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("users")
    suspend fun fetchUsers(): List<UserResponse>

    @GET("users/{login}")
    suspend fun fetchUserDetails(@Path("login") usersLogin: String): UserDetailsResponse
}