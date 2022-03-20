package com.qj0r9j0vc2.boilerplate.global.util

import org.springframework.security.core.context.SecurityContextHolder

class CurrentToken {

    fun getTokenCredentials(): String {
        return SecurityContextHolder.getContext().authentication.credentials.toString()
    }



}