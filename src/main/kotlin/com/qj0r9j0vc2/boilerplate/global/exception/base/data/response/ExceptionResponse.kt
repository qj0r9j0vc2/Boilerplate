package com.qj0r9j0vc2.boilerplate.global.exception.base.data.response

import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

data class ExceptionResponse(
    val error: ErrorCode,
    val data: String
)