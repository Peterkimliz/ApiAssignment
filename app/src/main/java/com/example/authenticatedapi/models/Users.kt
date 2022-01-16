package com.example.authenticatedapi.models
data class usersResponse(val results: List<Users>)
data class Users(
    val firstname:String,
    val lastname:String
)