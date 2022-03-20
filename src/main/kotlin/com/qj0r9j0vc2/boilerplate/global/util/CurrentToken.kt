package com.qj0r9j0vc2.boilerplate.global.util

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.User
import com.qj0r9j0vc2.boilerplate.domain.account.data.exception.UserNotFoundException
import com.qj0r9j0vc2.boilerplate.domain.account.repository.UserRepository
import com.qj0r9j0vc2.boilerplate.global.security.exception.InvalidJwtException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component


@Component
class CurrentToken(
    private val userRepository: UserRepository

) {

    fun getTokenCredentials(): String {
        return SecurityContextHolder.getContext().authentication.credentials.toString()
    }

    fun getUser(): User {
        return userRepository.findByEmail(getTokenCredentials()).orElse(null)?: throw InvalidJwtException("null")
    }



}