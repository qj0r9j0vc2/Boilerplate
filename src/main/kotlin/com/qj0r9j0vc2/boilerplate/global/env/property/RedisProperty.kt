package com.qj0r9j0vc2.boilerplate.global.env.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("redis")
data class RedisProperty(
    val host: String,
    val port: Int
)
