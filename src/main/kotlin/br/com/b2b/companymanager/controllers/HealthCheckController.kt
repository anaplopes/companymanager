package br.com.b2b.companymanager.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/healthcheck")
class HealthCheckController {

    @GetMapping
    fun check(): String {
        return "Ok"
    }
}