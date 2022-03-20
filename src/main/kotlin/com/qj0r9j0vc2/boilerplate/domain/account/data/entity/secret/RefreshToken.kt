package com.qj0r9j0vc2.boilerplate.domain.account.data.entity.secret

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    userId: String,
    refreshToken: String,
    ttl: Long
) {

    @Id
    private val id: String = userId
    @Indexed
    private val refreshToken: String = refreshToken
    @TimeToLive
    private val ttl = ttl

    fun getRefreshToken(): String{
        return refreshToken
    }

}