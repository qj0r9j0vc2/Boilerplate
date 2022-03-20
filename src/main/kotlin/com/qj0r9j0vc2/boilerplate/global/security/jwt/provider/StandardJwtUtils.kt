package com.qj0r9j0vc2.boilerplate.global.security.jwt.provider

import com.qj0r9j0vc2.boilerplate.global.security.exception.InvalidJwtException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.sql.Timestamp
import java.time.LocalDateTime


abstract class StandardJwtUtils<T>: JwtUtils<T> {

    override fun encode(data: T): String {
        return Jwts.builder()
            .setClaims(getClaims(data))
            .signWith(SignatureAlgorithm.ES256, getSecretKey())
            .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
            .setExpiration(Timestamp.valueOf(getExpiredAt(LocalDateTime.now())))
            .compact()
    }

    override fun decode(token: String): T {
        val claims: Claims
        try {
            claims = Jwts.parser()
                .setSigningKey(getSecretKey())
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            throw InvalidJwtException(token)
        }
        return getDataClaims(claims)
    }

    protected abstract fun getClaims(data: T): Map<String, String>

    protected abstract fun getDataClaims(claims: Claims): T

    protected abstract fun getExpiredAt(now: LocalDateTime): LocalDateTime

    protected abstract fun getSecretKey(): String

}