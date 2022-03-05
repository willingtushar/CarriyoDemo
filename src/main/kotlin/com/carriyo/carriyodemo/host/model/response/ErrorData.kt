package com.carriyo.carriyodemo.host.model.response

data class ErrorData(
    val errorDescription: String,
    val errorCode: String,
    val additionalData: Any
)
