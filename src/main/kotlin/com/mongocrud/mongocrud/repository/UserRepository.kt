package com.mongocrud.mongocrud.repository

import com.mongocrud.mongocrud.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository:MongoRepository<User,String> {
}

interface UserPaginationRepository : PagingAndSortingRepository<User, Long>
