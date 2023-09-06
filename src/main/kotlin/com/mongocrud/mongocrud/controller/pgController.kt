package com.mongocrud.mongocrud.controller
import com.mongocrud.mongocrud.model.UserReponse
import com.mongocrud.mongocrud.repository.UserPaginationRepository
import com.mongocrud.mongocrud.repository.UserRepository
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/pagination/users")
class PaginationController (val userPaginationRepo : UserPaginationRepository){

    @RequestMapping()
    fun paginatedUser()= userPaginationRepo.findAll(
        PageRequest.of(
            1,
            2,
            Sort.by("semesterGpa").descending().and(Sort.by("id"))
        )
    ).toList()

    @RequestMapping("/dynamic")
    fun dynamicPagination(@RequestParam (defaultValue ="1" )page:Int, @RequestParam(defaultValue = "5") size :Int)= userPaginationRepo.findAll(
        PageRequest.of(
            page,
            size,
            Sort.by("semesterGpa").descending().and(Sort.by("id"))
        )
    ).let {
        UserReponse(
            items =it.toList(),
            hasNext = it.hasNext()

        )
    }
}
