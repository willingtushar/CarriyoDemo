package com.carriyo.carriyodemo.host.model.request.user

data class Address (
    val addressLine1: String,
    val addressLine2: String?,
    val addressLine3: String?,
    val landmark: String?,
    val postalCode: String,
    val city: String,
    val state: String,
    val country: String,
    val addressTags: List<AddressTag>
)


