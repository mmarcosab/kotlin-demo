package com.example.kotlinstudies.adapter.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping
    fun getHome(): String {
        return "OK OK";
    }

}