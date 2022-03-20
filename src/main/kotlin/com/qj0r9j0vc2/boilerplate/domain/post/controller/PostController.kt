package com.qj0r9j0vc2.boilerplate.domain.post.controller

import com.qj0r9j0vc2.boilerplate.domain.post.data.dto.MinimumPost
import com.qj0r9j0vc2.boilerplate.domain.post.data.request.CreatePostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.request.EditPostRequest
import com.qj0r9j0vc2.boilerplate.domain.post.data.response.MinimumPostListResponse
import com.qj0r9j0vc2.boilerplate.domain.post.service.PostService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/post")
class PostController(
    private val postService: PostService

) {

    @GetMapping("/list/{idx}/{size}")
    fun getPostListByPaging(@PathVariable idx: Int, @PathVariable size: Int): MinimumPostListResponse {
        return postService.getPostList(idx, size)
    }

    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: String): MinimumPost {
        return postService.getPost(postId)
    }

    @PostMapping
    fun createPost(@RequestBody r: CreatePostRequest) {
        return postService.createPost(r)
    }

    @PatchMapping
    fun editPost(@RequestParam id: String, @RequestBody r: EditPostRequest) {
        return postService.editPost(r, id)
    }

}