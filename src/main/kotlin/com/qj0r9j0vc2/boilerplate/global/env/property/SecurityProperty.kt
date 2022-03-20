package com.qj0r9j0vc2.boilerplate.global.env.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties("jwt")
data class SecurityProperty (
    val mapKey: String,
    val secretKey: String,
    val accessExpiredAt: Long,
    val refreshExpiredAt: Long

)