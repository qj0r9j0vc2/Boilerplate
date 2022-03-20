package com.qj0r9j0vc2.boilerplate.domain.account.data.entity

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Gender
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Role
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@DiscriminatorColumn(name = "user_type")
abstract class User(
    email: String,
    firstName: String,
    lastName: String,
    birth: LocalDate,
    gender: Gender,
    role: Role,
    password: String,
    school: String
) {
    @Id
    private val id: String = UUID.randomUUID().toString()
    @Column(unique = true, length = 30)
    private val email: String = email
    @Column(length = 10)
    private val firstName: String = firstName
    @Column(length = 10)
    private val lastName: String = lastName

    private val birth: LocalDate = birth

    private val gender: Gender = gender

    private val role: Role = role

    private val password: String = password
    @CreationTimestamp
    private val createAt: LocalDate? = null
    @UpdateTimestamp
    private val updateAt: LocalDate? = null

    private val school: String = school

    fun getRole(): Role {
        return this.role
    }

    fun getPassword(): String{
        return this.password
    }

    fun getEmail(): String{
        return this.email
    }

}