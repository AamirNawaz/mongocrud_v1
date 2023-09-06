package com.mongocrud.mongocrud.model

data class UserReponse(
    val items :Iterable<User>,
    val hasNext :Boolean
)
