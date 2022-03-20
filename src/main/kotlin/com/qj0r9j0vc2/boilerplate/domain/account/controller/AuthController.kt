package com.qj0r9j0vc2.boilerplate.domain.account.controller

import com.qj0r9j0vc2.boilerplate.domain.account.data.request.LoginRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.ReissueRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.StudentSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.TeacherSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.response.TokenResponse
import com.qj0r9j0vc2.boilerplate.domain.account.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(r: LoginRequest): TokenResponse {
        return authService.login(r)
    }

    @PostMapping("/signup/student")
    fun studentSignup(r: StudentSignupRequest) {
        return authService.studentSignup(r)
    }

    @PostMapping("/signup/teacher")
    fun teacherSignup(r: TeacherSignupRequest){
        return authService.teacherSignup(r)
    }

    @PostMapping("/reissue")
    fun reissue(r: ReissueRequest): TokenResponse {
        return authService.reissue(r)
    }


}