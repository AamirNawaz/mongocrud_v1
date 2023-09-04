package com.mongocrud.mongocrud.service

import com.mongocrud.mongocrud.model.User
import com.mongocrud.mongocrud.repository.UserRepository
import org.springframework.data.annotation.Id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepo :UserRepository ){

    //Get Users
    fun getAllUsers():List<User> {
        return userRepo.findAll()
    }

    //Get User by Id
    fun getUserById(id : String):User? = userRepo.findByIdOrNull(id)


    //Get Users Counts
    fun getUsersCount():Int = userRepo.findAll().count()


    //Save User
    fun saveUser(user: User):User =userRepo.save(user)


    //delete user
    fun deleteUser(id: String) = userRepo.deleteById(id)

    //update user
    fun updateUser(user: User) = userRepo.save(user)

}