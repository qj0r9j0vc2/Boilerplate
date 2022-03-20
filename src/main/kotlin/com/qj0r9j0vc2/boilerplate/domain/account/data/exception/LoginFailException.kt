package com.qj0r9j0vc2.boilerplate.domain.account.data.exception

import com.qj0r9j0vc2.boilerplate.global.exception.base.GlobalException
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

class LoginFailException(data: String): GlobalException(ErrorCode.LOGIN_FAIL, data) {
}