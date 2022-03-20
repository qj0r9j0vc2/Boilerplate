package com.qj0r9j0vc2.boilerplate.domain.post.service

import com.qj0r9j0vc2.boilerplate.domain.post.data.dto.MinimumPost
import com.qj0r9j0vc2.boilerplate.domain.post.data.request.CreatePostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.request.EditPostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.response.MinimumPostListResponse

interface PostService {

    fun getPostList(idx: Int, size: Int): MinimumPostListResponse
    fun getPost(postId: String): MinimumPost
    fun createPost(r: CreatePostRequest)
    fun editPost(r: EditPostRequest, postId: String)

}