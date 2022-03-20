package com.qj0r9j0vc2.boilerplate.global.security.filter

import com.qj0r9j0vc2.boilerplate.global.security.jwt.provider.AccessTokenUtils
import com.qj0r9j0vc2.boilerplate.global.security.jwt.userDetails.CustomUserDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val customUserDetailsService: CustomUserDetailsService,
    private val jwtUtils: AccessTokenUtils
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        getToken(request)?.let {
            val subject = jwtUtils.decode(it)
            val userDetails = customUserDetailsService.loadUserByUsername(subject)
            SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken(userDetails, subject, userDetails.authorities)
        }

    }

    private fun getToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader("Authroization")
        if (bearer.startsWith("Bearer ")) return bearer.substring(7)
        return null
    }

}