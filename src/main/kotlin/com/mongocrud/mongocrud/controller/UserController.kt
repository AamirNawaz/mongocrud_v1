package com.mongocrud.mongocrud.controller

import com.mongocrud.mongocrud.model.User
import com.mongocrud.mongocrud.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(@Autowired val userSrv:UserService) {
    //With ResponseEntity @GetMapping
    fun getUsers(): List<User> {
        return userSrv.getAllUsers()
    }

    //Without ResponseEntity
    @GetMapping("/{id}")
    fun getUser( @PathVariable id: String): User? {
        return userSrv.getUserById(id)
    }

    @GetMapping("/counts")
    fun getUsersCounts():Int{
        return userSrv.getUsersCount()
    }

    @PostMapping("add")
    fun saveUser(@RequestBody user: User ): User {
       return userSrv.saveUser(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String):String{
        userSrv.deleteUser(id)
        return "Record deleted successfully ID : $id"
    }

 @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String,@RequestBody user: User): ResponseEntity<User> {
     val existingUser = userSrv.getUserById(id)
     return if (existingUser !=null){
         val updateUser = user.copy(id = existingUser.id)
         userSrv.updateUser(updateUser)
         ResponseEntity(updateUser, HttpStatus.OK)
     }else{
         ResponseEntity(HttpStatus.NOT_FOUND)
     }
    }

}