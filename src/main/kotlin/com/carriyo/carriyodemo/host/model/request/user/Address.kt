package com.carriyo.carriyodemo.host.model.request.user

import com.carriyo.carriyodemo.host.model.Constants.addressLine1ErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.addressLine1Regx
import com.carriyo.carriyodemo.host.model.Constants.addressLine2ErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.addressLine2Regx
import com.carriyo.carriyodemo.host.model.Constants.addressLine3ErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.addressLine3Regx
import com.carriyo.carriyodemo.host.model.Constants.cityErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.landmarkErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.landmarkRegx
import com.carriyo.carriyodemo.host.model.Constants.postalCodeErrorMessage
import com.carriyo.carriyodemo.host.model.Constants.postalCodeRegx
import com.carriyo.carriyodemo.host.model.Constants.stateErrorMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class Address (
    @field:Pattern(regexp = addressLine1Regx, message = addressLine1ErrorMessage)
    val addressLine1: String,

    @field:Pattern(regexp = addressLine2Regx, message = addressLine2ErrorMessage)
    val addressLine2: String?,

    @field:Pattern(regexp = addressLine3Regx, message = addressLine3ErrorMessage)
    val addressLine3: String?,

    @field:Pattern(regexp = landmarkRegx, message = landmarkErrorMessage)
    val landmark: String?,

    @field:Pattern(regexp = postalCodeRegx, message = postalCodeErrorMessage)
    val postalCode: String,

    @field:NotEmpty(message = cityErrorMessage)
    val city: String,

    @field:NotEmpty(message = stateErrorMessage)
    val state: String,

    val country: String,

    val addressTags: List<AddressTag>
)


