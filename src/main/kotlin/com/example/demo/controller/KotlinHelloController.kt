package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinHelloController {

    @GetMapping("/kotlin")
    fun sayHello(): String {
        return "Hello, Kotlin!"
    }
}