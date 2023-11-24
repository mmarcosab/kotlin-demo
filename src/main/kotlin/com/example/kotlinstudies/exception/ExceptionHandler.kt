package com.example.kotlinstudies.exception

import com.example.kotlinstudies.dto.ErrorDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun handleNotFound(
            exception: NotFoundException,
            request: HttpServletRequest
    ): ErrorDto {
        return ErrorDto(
                status = NOT_FOUND.value(),
                error = NOT_FOUND.name,
                message = exception.message,
                path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handleBadRequest(
            exception: NotFoundException,
            request: HttpServletRequest
    ): ErrorDto {
        return ErrorDto(
                status = BAD_REQUEST.value(),
                error = BAD_REQUEST.name,
                message = exception.message,
                path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    fun handleInternalServerError(
            exception: NotFoundException,
            request: HttpServletRequest
    ): ErrorDto {
        return ErrorDto(
                status = INTERNAL_SERVER_ERROR.value(),
                error = INTERNAL_SERVER_ERROR.name,
                message = exception.message,
                path = request.servletPath
        )
    }
}