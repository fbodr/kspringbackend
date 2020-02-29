package org.example.kspringbackend.endpoint

import org.example.kspringbackend.config.AboutConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class EndpointController(
    private val aboutConfig: AboutConfig
) {

    @GetMapping("/about")
    fun about() = aboutConfig

    @GetMapping("/private/basic")
    fun basic() = "Basic Auth protected endpoint"
}