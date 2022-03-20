package com.qj0r9j0vc2.boilerplate.domain.account.data.request

import com.qj0r9j0vc2.boilerplate.domain.account.data.dto.SignupFacadeRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Gender
import java.time.LocalDate

data class StudentSignupRequest (
    val email: String,
    val firstName: String,
    val lastName: String,
    val birth: LocalDate,
    val gender: Gender,
    val password: String,
    val grade: Int,
    val classNum: Int,
    val number: Int,
    val school: String,
    val teacherId: String
) {
    fun toSignupFacadeRequest(): SignupFacadeRequest {
        return SignupFacadeRequest(
            email,
            password
        )
    }
}