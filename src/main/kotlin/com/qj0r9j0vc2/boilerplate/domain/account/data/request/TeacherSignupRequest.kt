package com.qj0r9j0vc2.boilerplate.domain.account.data.request

import com.qj0r9j0vc2.boilerplate.domain.account.data.dto.SignupFacadeRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Gender
import java.time.LocalDate

data class TeacherSignupRequest (
    val email: String,
    val firstName: String,
    val lastName: String,
    val birth: LocalDate,
    val gender: Gender,
    val password: String,
    val school: String
) {
    fun toSignupFacadeRequest(): SignupFacadeRequest {
        return SignupFacadeRequest(
            email,
            password
        )
    }
}