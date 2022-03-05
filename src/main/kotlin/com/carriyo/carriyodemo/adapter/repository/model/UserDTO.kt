package com.carriyo.carriyodemo.adapter.repository.model

data class UserDTO(
    val userId: String,
    val firstName: String,
    val lastName: String?,
    val email: String,
    val mobileNumber: MobileNumberDTO,
    val addresses: List<AddressDTO>
)
