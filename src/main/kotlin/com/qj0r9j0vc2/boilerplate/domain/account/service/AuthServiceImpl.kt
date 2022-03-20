package com.qj0r9j0vc2.boilerplate.domain.account.service

import com.qj0r9j0vc2.boilerplate.domain.account.data.dto.SignupFacadeRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.Student
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.Teacher
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.secret.RefreshToken
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Role
import com.qj0r9j0vc2.boilerplate.domain.account.data.exception.*
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.LoginRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.ReissueRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.StudentSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.TeacherSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.response.TokenResponse
import com.qj0r9j0vc2.boilerplate.domain.account.repository.RefreshTokenRepository
import com.qj0r9j0vc2.boilerplate.domain.account.repository.StudentRepository
import com.qj0r9j0vc2.boilerplate.domain.account.repository.TeacherRepository
import com.qj0r9j0vc2.boilerplate.domain.account.repository.UserRepository
import com.qj0r9j0vc2.boilerplate.global.security.jwt.provider.AccessTokenUtils
import com.qj0r9j0vc2.boilerplate.global.security.jwt.provider.RefreshTokenUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository,
    private val accessTokenUtils: AccessTokenUtils,
    private val refreshTokenUtils: RefreshTokenUtils,
    private val refreshTokenRepository: RefreshTokenRepository

): AuthService {

    private val REFRESH_EXPIRED_AT: Long = 120960000

    override fun login(r: LoginRequest): TokenResponse {
        val user = userRepository.findByEmail(r.email).orElse(null)?: throw UserNotFoundException(r.email)
        if (encoder.matches(r.password, user.getPassword())) {
            return tokenProvide(r.email)
        }
        throw LoginFailException(r.password)
    }

    override fun studentSignup(r: StudentSignupRequest) {
        val checked = signupFacade(r.toSignupFacadeRequest())
        val teacher = teacherRepository.findByEmail(r.teacherId)
            .orElse(null)?:
            throw TeacherNotFoundException(r.teacherId)

        studentRepository.save(
            Student(
                checked.email,
                r.firstName,
                r.lastName,
                r.birth,
                r.gender,
                Role.COMMON,
                checked.password,
                r.grade,
                r.classNum,
                r.number,
                r.school,
                teacher
            )
        )
    }

    override fun teacherSignup(r: TeacherSignupRequest) {
        val checked = signupFacade(r.toSignupFacadeRequest())
        teacherRepository.save(
            Teacher(
                checked.email,
                r.firstName,
                r.lastName,
                r.birth,
                r.gender,
                Role.UNIQUE,
                checked.password,
                r.school
            )
        )
    }

    private fun signupFacade(request: SignupFacadeRequest): SignupFacadeRequest {
        emailCheck(request.email)
        return SignupFacadeRequest(
                request.email,
                encoder.encode(request.password)
        )
    }

    private fun emailCheck(email: String): String {
        userRepository.findByEmail(email).orElse(null)?.let{throw EmailUserAlreadyExistsException(email)}
        return email
    }

    override fun reissue(r: ReissueRequest): TokenResponse {
        val token = refreshTokenRepository.findById(r.userEmail).orElse(null)?: throw UserNotFoundException(r.userEmail)
        if (r.refreshToken.equals(token.getRefreshToken())) return tokenProvide(r.userEmail)
        throw ReissueFailException(r.userEmail)
    }

    private fun tokenProvide(email: String): TokenResponse {
        val refreshToken = refreshTokenUtils.encode(email)
        refreshTokenRepository.save(
            RefreshToken(
                email,
                refreshToken,
                REFRESH_EXPIRED_AT
            )
        )
        return TokenResponse(
            accessTokenUtils.encode(email),
            refreshToken
        )
    }
}