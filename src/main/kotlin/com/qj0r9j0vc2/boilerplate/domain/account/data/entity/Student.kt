package com.qj0r9j0vc2.boilerplate.domain.account.data.entity

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Gender
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Role
import java.time.LocalDate
import javax.persistence.*


@Entity
@DiscriminatorValue("student")
class Student(
    email: String,
    firstName: String,
    lastName: String,
    birth: LocalDate,
    gender: Gender,
    role: Role,
    password: String,
    grade: Int,
    classNum: Int,
    number: Int,
    school: String,
    teacher: Teacher
): User(
    email,
    firstName,
    lastName,
    birth,
    gender,
    role,
    password,
    school
) {
    private val grade: Int = grade
    private val classNum: Int = classNum
    private val number: Int = number
    @ManyToOne(fetch = FetchType.LAZY)
    private val teacher: Teacher = teacher

}