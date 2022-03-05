package com.carriyo.carriyodemo.host.model.request.user

import com.carriyo.carriyodemo.host.model.Constants.emailAddressRegx
import com.carriyo.carriyodemo.host.model.Constants.firstNameLengthErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.lastNameLengthErrorMessage
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.Pattern


data class User(
    val userId: String? = null,

    @field:Length(min = 4, max = 30, message = firstNameLengthErrorMessage)
    val firstName: String,

    @field:Length(min = 4, max = 30, message = lastNameLengthErrorMessage)
    val lastName: String?,

    @field:Pattern(regexp = emailAddressRegx)
    val email: String,

    @field:Valid
    val mobileNumber: MobileNumber,

    @field:Valid
    val addresses: List<Address>
)
