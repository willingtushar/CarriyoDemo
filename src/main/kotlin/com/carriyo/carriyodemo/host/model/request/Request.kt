package com.carriyo.carriyodemo.host.model.request

import javax.validation.Valid

data class Request<T: Any> (
    @field:Valid
    val requestHeader: RequestHeader,

    @field:Valid
    val data: T
)

