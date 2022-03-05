package com.carriyo.carriyodemo.host.model.request.user


data class User(
    val userId: String? = null,
    val firstName: String,
    val lastName: String?,
    val email: String,
    val mobileNumber: MobileNumber,
    val addresses: List<Address>
)
