package com.qj0r9j0vc2.boilerplate.global.exception.base.data.type

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    POST_CANNOT_FOUND("post를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_JWT("올바르지 않은 jwt입니다.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("user를 찾지 못했습니다.", HttpStatus.NOT_FOUND),
    EMAIL_USER_ALREADY_EXISTS("해당 email로 가입한 user가 존재합니다.", HttpStatus.BAD_REQUEST),
    EMAIL_TEACHER_NOT_FOUND("해당 email의 teacher를 찾지 못했습니다.", HttpStatus.NOT_FOUND)



}