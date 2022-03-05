package com.carriyo.carriyodemo.host.model.response

import java.time.Instant
import java.time.format.DateTimeFormatter

sealed class Response {
    val responseHeader =  ResponseHeader(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))
}

class SuccessResponse<T : Any> (
    val data: T
) : Response()

class ErrorResponse(
    val errorResponse: ErrorData
) : Response()
