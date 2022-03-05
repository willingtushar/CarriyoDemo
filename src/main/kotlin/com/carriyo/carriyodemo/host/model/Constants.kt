package com.carriyo.carriyodemo.host.model

object Constants {
    const val v1BaseUrl = "/v1/carriyoservices"

    const val userDeletedMessage = "user deleted successfully"

    // validation error messages and regex
    const val firstNameLengthErrorMessage = "first name should contain min 4 and max 30 characters"
    const val lastNameLengthErrorMessage = "last name should contain min 4 and max 30 characters"
    const val mobileNumberErrorMessage = "mobile number should have exact 10 digits"
    const val addressLine1Regx = "^[a-zA-Z0-9,\\/@.:\\-&][a-zA-Z0-9 ,\\/@.:\\-&]{1,48}[a-zA-Z0-9,\\/@.:\\-&]$"
    const val addressLine1ErrorMessage = "addressLine1 should have minimum 3 characters and maximum 50 characters"
    const val addressLine2Regx = """^[a-zA-Z0-9,\/@.:\-&][a-zA-Z0-9 ,\/@.:\-&]{1,48}[a-zA-Z0-9,\/@.:\-&]$"""
    const val addressLine2ErrorMessage = "addressLine2 should have minimum 3 characters and maximum 50 characters"
    const val addressLine3Regx = """^[a-zA-Z0-9,\/@.:\-&][a-zA-Z0-9 ,\/@.:\-&]{1,48}[a-zA-Z0-9,\/@.:\-&]$"""
    const val addressLine3ErrorMessage = "addressLine3 should have minimum 3 characters and maximum 50 characters"
    const val landmarkRegx = """^[a-zA-Z0-9,\/@.:\-&][a-zA-Z0-9 ,\/@.:\-&]{1,48}[a-zA-Z0-9,\/@.:\-&]$"""
    const val landmarkErrorMessage = "landmark should have minimum 3 characters and maximum 50 characters"
    const val postalCodeRegx = """^\d{6}$"""
    const val postalCodeErrorMessage = "Postal Code should contain only 6 numbers"
    const val cityErrorMessage = "City should not be empty"
    const val stateErrorMessage = "State should not be empty"
    const val mobileNumberRegex = """^[1-9]\d{9}$"""
    const val emailAddressRegx = """^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,})+$"""

}
