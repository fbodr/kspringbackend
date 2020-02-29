package org.example.kspringbackend.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix="application.about")
data class AboutConfig(
    val name: String,
    val email: String,
    val social: Social
)

data class Social(
    val github: String,
    val gitlab: String,
    val twitter: String,
    val mastodon: String
)