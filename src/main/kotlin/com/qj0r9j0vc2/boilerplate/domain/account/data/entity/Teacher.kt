package com.qj0r9j0vc2.boilerplate.domain.account.data.entity

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Gender
import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.type.Role
import java.time.LocalDate
import java.util.ArrayList
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany


@Entity
@DiscriminatorValue("teacher")
class Teacher(
    email: String,
    firstName: String,
    lastName: String,
    birth: LocalDate,
    gender: Gender,
    role: Role,
    password: String,
    school: String
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

    @OneToMany(fetch = FetchType.LAZY)
    private val studentListToManage: List<Student> = ArrayList()


}