package com.qj0r9j0vc2.boilerplate.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.qj0r9j0vc2.boilerplate.global.exception.base.data.response.ExceptionResponse
import com.qj0r9j0vc2.boilerplate.global.security.exception.InvalidJwtException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtExceptionHandlerFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: InvalidJwtException){
        response.status = e.errorCode.status.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "UTF-8"
        objectMapper.writeValue(response.writer, ExceptionResponse(
            e.errorCode,
            e.data
        ))
    }


    }


}