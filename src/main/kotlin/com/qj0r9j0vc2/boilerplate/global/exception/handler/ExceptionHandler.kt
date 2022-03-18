package com.qj0r9j0vc2.boilerplate.global.exception.handler

import com.qj0r9j0vc2.boilerplate.global.exception.base.GlobalException
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.response.ExceptionResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController


@RestController
@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(GlobalException::class)
    fun GlobalExceptionHandler(exception: GlobalException): ResponseEntity<*> {
        return ResponseEntity.status(exception.errorCode.status).body(
            ExceptionResponse(
                exception.errorCode,
                exception.data
            )
        )
    }


}