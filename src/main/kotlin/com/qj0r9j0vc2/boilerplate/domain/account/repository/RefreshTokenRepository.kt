package com.qj0r9j0vc2.boilerplate.domain.account.repository

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.secret.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}