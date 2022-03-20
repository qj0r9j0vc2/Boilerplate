package com.qj0r9j0vc2.boilerplate.global.env.configuration

import com.qj0r9j0vc2.boilerplate.global.env.property.RedisProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfiguration(
    private val redisProperty: RedisProperty
) {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory? {
        return LettuceConnectionFactory(redisProperty.host, redisProperty.port)
    }
}
