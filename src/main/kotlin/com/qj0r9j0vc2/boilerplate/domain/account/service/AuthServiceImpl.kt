package com.qj0r9j0vc2.boilerplate.domain.account.service

import com.qj0r9j0vc2.boilerplate.domain.account.data.dto.SignupFacadeRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.Student
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.Teacher
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Role
import com.qj0r9j0vc2.boilerplate.domain.account.data.exception.EmailUserAlreadyExistsException
import com.qj0r9j0vc2.boilerplate.domain.account.data.exception.TeacherNotFoundException
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.LoginRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.StudentSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.request.TeacherSignupRequest
import com.qj0r9j0vc2.boilerplate.domain.account.data.response.TokenResponse
import com.qj0r9j0vc2.boilerplate.domain.account.repository.StudentRepository
import com.qj0r9j0vc2.boilerplate.domain.account.repository.TeacherRepository
import com.qj0r9j0vc2.boilerplate.domain.account.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder,
    private val teacherRepository: TeacherRepository,
    private val studentRepository: StudentRepository
): AuthService {

    override fun login(request: LoginRequest): TokenResponse {
        TODO("로그인")
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

    override fun refresh(): TokenResponse {
        TODO("Not yet implemented")
    }
}