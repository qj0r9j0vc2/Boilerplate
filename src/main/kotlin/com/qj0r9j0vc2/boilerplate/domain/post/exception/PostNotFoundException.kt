package com.qj0r9j0vc2.boilerplate.domain.post.exception

import com.qj0r9j0vc2.boilerplate.global.exception.base.GlobalException
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.type.ErrorCode

class PostNotFoundException(data: String): GlobalException(ErrorCode.POST_NOT_FOUND, data) {
}