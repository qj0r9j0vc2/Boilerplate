package com.qj0r9j0vc2.boilerplate.domain.post.data.response

import com.qj0r9j0vc2.boilerplate.domain.post.data.dto.MinimumPost

data class MinimumPostListResponse(
    val page: Int,
    val size: Int,
    val postList: List<MinimumPost>

)
