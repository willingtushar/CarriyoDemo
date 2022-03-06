package com.carriyo.carriyodemo.adapter.repository.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
data class AddressDTO (
    @DynamoDBAttribute
    var addressLine1: String = "",

    @DynamoDBAttribute
    var addressLine2: String? = null,

    @DynamoDBAttribute
    var addressLine3: String? = null,

    @DynamoDBAttribute
    var landmark: String? = null,

    @DynamoDBAttribute
    var postalCode: String = "",

    @DynamoDBAttribute
    var city: String = "",

    @DynamoDBAttribute
    var state: String = "",

    @DynamoDBAttribute
    var country: String = "",

    @DynamoDBAttribute
    var addressTags: List<AddressTagDTO> = emptyList()
)


