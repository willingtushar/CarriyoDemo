package com.carriyo.carriyodemo.host.model.request

data class Request<T: Any> (
    val requestHeader: RequestHeader,
    val data: T
)

