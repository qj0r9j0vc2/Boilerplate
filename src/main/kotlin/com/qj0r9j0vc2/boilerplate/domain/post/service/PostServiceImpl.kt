package com.qj0r9j0vc2.boilerplate.domain.post.service

import com.qj0r9j0vc2.boilerplate.domain.post.data.request.CreatePostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.request.EditPostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.response.MinimumPostListResponse
import com.qj0r9j0vc2.boilerplate.domain.post.data.dto.MinimumPost
import com.qj0r9j0vc2.boilerplate.domain.post.data.entity.Post
import com.qj0r9j0vc2.boilerplate.domain.post.exception.PostNotFoundException
import com.qj0r9j0vc2.boilerplate.domain.post.repository.PostRepository
import com.qj0r9j0vc2.boilerplate.global.util.CurrentToken
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val current: CurrentToken
): PostService {
    override fun getPostList(idx: Int, size: Int): MinimumPostListResponse {
        val minimumPostList = postRepository.findAll(PageRequest.of(idx, size)).stream().map {
            it.toMinimumPost()
        }.toList()
        return MinimumPostListResponse(
            idx,
            size,
            minimumPostList
        )
    }

    override fun getPost(postId: String): MinimumPost {
        val minimumPost = postRepository.findById(postId).orElse(null)?.toMinimumPost()
            ?: throw PostNotFoundException(postId)

        return minimumPost
    }

    override fun createPost(r: CreatePostRequest) {
        postRepository.save(
            Post(
                r.title,
                current.getUser(),
                r.content
            )
        )
    }

    override fun editPost(r: EditPostRequest, postId: String) {
        val post = postRepository.findById(postId).orElse(null)?: throw PostNotFoundException(postId)
        post.editContent(r.content)
        post.editTitle(r.title)
    }


}