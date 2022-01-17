package com.example.authenticatedapi.repository

import com.example.authenticatedapi.network.RetrofitInstance
import com.example.authenticatedapi.utils.Constants.Companion.TOKEN

class Repository () {
    suspend fun getUsers() = RetrofitInstance.api.getTopUsers()
    //suspend fun getUsers() = RetrofitInstance.api.getTopUsers("Bearer $TOKEN")
    }