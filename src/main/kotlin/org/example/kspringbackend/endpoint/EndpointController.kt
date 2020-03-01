package org.example.kspringbackend.endpoint

import org.example.kspringbackend.config.AboutConfig
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class EndpointController(
    private val aboutConfig: AboutConfig
) {

    @GetMapping("/about")
    fun about() = aboutConfig

    @GetMapping("/private/basic")
    fun basic(): String {
        val securityContext = SecurityContextHolder.getContext()
        return """
              Name: ${securityContext.authentication.name}<br>
              Principal: ${securityContext.authentication.principal}<br>
              Details: ${securityContext.authentication.details}<br>
              Authorities: ${securityContext.authentication.authorities}<br>
              Credentials: ${securityContext.authentication.credentials}<br>
            """.trimIndent()
    }
}