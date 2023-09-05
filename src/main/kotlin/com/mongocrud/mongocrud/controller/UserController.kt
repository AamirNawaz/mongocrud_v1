package com.mongocrud.mongocrud.controller

import com.mongocrud.mongocrud.model.User
import com.mongocrud.mongocrud.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Validated
class UserController(@Autowired val userSrv:UserService) {
    //With ResponseEntity
    @GetMapping
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

    @PostMapping("/add")
    fun saveUser(@Valid @RequestBody user: User ): ResponseEntity<String> {
      userSrv.saveUser(user)
        return ResponseEntity.ok("User created successfully")

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


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>> {
        val errors = ex.bindingResult.fieldErrors.map { fieldError ->
            fieldError.field to fieldError.defaultMessage.orEmpty()
        }.toMap()

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }


}