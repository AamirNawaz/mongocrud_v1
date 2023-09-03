package com.mongocrud.mongocrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongocrudApplication

fun main(args: Array<String>) {
    runApplication<MongocrudApplication>(*args)
}
