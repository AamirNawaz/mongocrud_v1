package com.mongocrud.mongocrud.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("users")
data class User(
    @Id
    val id: String = ObjectId().toHexString(),


    @field:NotNull
    @field:NotBlank(message = "Name is required")
    @field:NotEmpty
    val name:String,

    @field:Email
    @field:NotBlank
    @field:NotNull
    val email:String ,

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

