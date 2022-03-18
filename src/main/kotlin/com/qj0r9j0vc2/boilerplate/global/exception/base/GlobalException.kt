package com.qj0r9j0vc2.boilerplate.global.exception.base

import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

open class GlobalException(val errorCode: ErrorCode, val data: String): RuntimeException(errorCode.message) {
}