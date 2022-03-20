package com.qj0r9j0vc2.boilerplate.domain.post.repository

import com.qj0r9j0vc2.boilerplate.domain.post.data.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, String> {

    override fun findAll(pageable: Pageable): Page<Post>

}