package com.qj0r9j0vc2.boilerplate.domain.account.service

import com.qj0r9j0vc2.boilerplate.domain.account.data.request.LoginRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.StudentSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.TeacherSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.response.TokenResponse

interface AuthService {

    fun login(request: LoginRequest): TokenResponse
    fun studentSignup(request: StudentSignupRequest)
    fun teacherSignup(request: TeacherSignupRequest)
    fun refresh(): TokenResponse
}