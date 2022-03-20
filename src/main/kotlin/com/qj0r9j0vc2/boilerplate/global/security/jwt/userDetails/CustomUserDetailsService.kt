package com.qj0r9j0vc2.boilerplate.global.security.jwt.userDetails

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.User
import com.qj0r9j0vc2.boilerplate.domain.account.data.exception.UserNotFoundException
import com.qj0r9j0vc2.boilerplate.domain.account.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): CustomUserDetails {
        return userRepository.findById(username).map { CustomUserDetails() }
            .orElse(null)?:throw UserNotFoundException(username)
    }

}