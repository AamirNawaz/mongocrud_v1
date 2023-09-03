package com.mongocrud.mongocrud.service

import com.mongocrud.mongocrud.model.User
import com.mongocrud.mongocrud.repository.UserRepository
import org.springframework.data.annotation.Id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepo :UserRepository ){

    //Get Users
    fun getAllUsers():List<User>{
        return userRepo.findAll()
    }

    //Get User by Id
    fun getUserById(id : String):User?{
        return userRepo.findByIdOrNull(id)
    }

    //Get Users Counts
    fun getUsersCount():Int{
        return userRepo.findAll().count()
    }

    //Save User
    fun saveUser(user: User):User{
          return userRepo.save(user)
    }

    fun deleteUser(id: String){
        return userRepo.deleteById(id)
    }

    fun updateUser(user: User): User {
       return userRepo.save(user)
    }
}