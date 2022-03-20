package com.qj0r9j0vc2.boilerplate.domain.post.data.entity

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.User
import com.qj0r9j0vc2.boilerplate.domain.post.data.dto.MinimumPost
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne


@Entity
class Post(
    title: String,
    writer: User,
    content: String
) {
    @Id
    private val id: String = UUID.randomUUID().toString()

    private var title: String = title

    @ManyToOne(fetch = FetchType.LAZY)
    private val writer: User = writer

    private var content: String = content


    fun toMinimumPost(): MinimumPost {
        return MinimumPost(
            title,
            content
        )
    }

    fun editContent(content: String) {
        this.content = content
    }

    fun editTitle(title: String) {
        this.title = title
    }


}