package com.mongocrud.mongocrud.repository

import com.mongocrud.mongocrud.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository:MongoRepository<User,String> {
}