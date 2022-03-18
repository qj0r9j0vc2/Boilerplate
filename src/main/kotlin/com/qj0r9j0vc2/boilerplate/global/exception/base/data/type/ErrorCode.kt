package com.qj0r9j0vc2.boilerplate.global.exception.base.data.type

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    POST_CANNOT_FOUND("post를 찾을 수 없습니다.", HttpStatus.NOT_FOUND)



}