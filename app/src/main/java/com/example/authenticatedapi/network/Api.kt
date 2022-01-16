package com.example.authenticatedapi.network

import com.example.authenticatedapi.models.Users
import com.example.authenticatedapi.models.usersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface Api {
     //////////////////////////////method for getting the firstname and lastname//////////
       //@Headers("Content-Type: application/json")
        @GET("users/recent")
        suspend fun getTopUsers(@Header("Authorization") Token:String): usersResponse
          }