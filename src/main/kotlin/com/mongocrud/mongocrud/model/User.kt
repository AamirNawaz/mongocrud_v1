package com.mongocrud.mongocrud.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("users")
data class User(
    @Id
    val id: String = ObjectId().toHexString(),
    val name:String ="",
    val email:String = "",
    val password:String ="",
    val fatherName :String ="",
    val age :Int =0,
    val status:Boolean = false,
    val address: Address
)

data class Address(
    val country:String ="",
    val home :String ="",
    val office:String="",
    val zipcode:String=""
)

