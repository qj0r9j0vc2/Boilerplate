package com.qj0r9j0vc2.boilerplate.global.exception

import com.qj0r9j0vc2.boilerplate.global.exception.base.GlobalException
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

class LowAuthenticationException(data: String): GlobalException(ErrorCode.POST_CANNOT_FOUND, data) {
}