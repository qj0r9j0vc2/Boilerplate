package com.qj0r9j0vc2.boilerplate.global.security.jwt.provider

interface JwtUtils<T> {
    fun encode(data: T): String
    fun decode(token: String): T
}