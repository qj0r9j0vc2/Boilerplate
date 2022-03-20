package com.qj0r9j0vc2.boilerplate.domain.account.repository

import com.qj0r9j0vc2.boilerplate.domain.account.data.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, String> {

}