package org.example.kspringbackend.endpoint

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Response(
    val msg: String
)
@RestController
class EndpointController {

    @GetMapping("/hello")
    fun get(): Response = Response(msg = "Hello!")
}