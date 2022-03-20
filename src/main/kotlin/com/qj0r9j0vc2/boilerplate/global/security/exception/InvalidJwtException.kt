package com.qj0r9j0vc2.boilerplate.global.security.exception

import com.qj0r9j0vc2.boilerplate.global.exception.base.GlobalException
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

class InvalidJwtException(data: String): GlobalException(ErrorCode.INVALID_JWT, data) {
}