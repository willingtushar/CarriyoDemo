package com.carriyo.carriyodemo.adapter.database.model


data class UserDTO(
    val firstName: String,
    val lastName: String?,
    val email: String,
    val mobileNumber: MobileNumberDTO,
    val addresses: List<AddressDTO>
)
