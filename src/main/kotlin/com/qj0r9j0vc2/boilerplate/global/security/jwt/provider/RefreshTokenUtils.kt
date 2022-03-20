package com.qj0r9j0vc2.boilerplate.global.security.jwt.provider

import com.qj0r9j0vc2.boilerplate.global.env.property.SecurityProperty
import io.jsonwebtoken.Claims
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
class RefreshTokenUtils(
    private val secret: SecurityProperty
): StandardJwtUtils<String>() {

    override fun getClaims(data: String): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map[data] = data
        return map
    }

    override fun getDataClaims(claims: Claims): String {
        return claims.get("refresh", String::class.java)
    }

    override fun getExpiredAt(now: LocalDateTime): LocalDateTime {
        return now.plusSeconds(secret.refreshExpiredAt)
    }

    override fun getSecretKey(): String {
        return secret.secretKey
    }
}