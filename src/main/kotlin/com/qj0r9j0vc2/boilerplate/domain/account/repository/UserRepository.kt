package com.qj0r9j0vc2.boilerplate.domain.account.repository

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, String> {
    fun findByEmail(email: String): Optional<User>
}