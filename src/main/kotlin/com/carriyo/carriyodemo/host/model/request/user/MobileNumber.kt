package com.carriyo.carriyodemo.host.model.request.user

import com.carriyo.carriyodemo.host.model.Constants
import javax.validation.constraints.Pattern

data class MobileNumber(
    val countryCode: String,

    @field:Pattern(regexp = Constants.mobileNumberRegex, message = Constants.mobileNumberErrorMessage)
    val number: String
)
