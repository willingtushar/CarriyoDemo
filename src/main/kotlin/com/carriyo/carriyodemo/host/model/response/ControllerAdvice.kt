package com.carriyo.carriyodemo.host.model.response

import com.carriyo.carriyodemo.utils.*
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(
        UserNotFoundException::class,
        UserAlreadyExistedException::class
    )
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleDatabaseBadRequestException(exception: DatabaseException): ErrorResponse {
        val errorCode = errorCodeFor(exception.fieldName)
        val errorResponse = ErrorData(exception.message, errorCode)
        return ErrorResponse(errorResponse)
    }

    @ExceptionHandler(
        MultipleCommunicationAddressException::class,
        MissingCommunicationAddressTagException::class,
        MultipleWorkAddressException::class,
        MultipleHomeAddressException::class,
        MissingUserIdInUpdateRequest::class
    )
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleValidationException(exception: ValidationException): ErrorResponse {
        val errorCode = errorCodeFor(exception.fieldName)
        val errorResponse = ErrorData(exception.message, errorCode)
        return ErrorResponse(errorResponse)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    fun handleDeserializationException(exception: HttpMessageNotReadableException): ErrorResponse{
        val errorCode = ""
        val errorResponse = ErrorData(exception.message, errorCode)
        return ErrorResponse(errorResponse)
    }

    private fun errorCodeFor(fieldName: String): String {
        return fieldSpecificErrorCodes[fieldName] ?: "CR000"
    }

    private val fieldSpecificErrorCodes = mapOf(
        "userAlreadyExisted" to "CR200",
        "userNotFound" to "CR201",
        "missingCommunicationTag" to "CR202",
        "oneThanOneCommunicationTag" to "CR203",
        "multipleWorkAddress" to "CR204",
        "multipleHomeAddress" to "CR205",
        "missingUserId" to "CR206"
    )
}
