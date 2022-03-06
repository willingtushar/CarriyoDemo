package com.carriyo.carriyodemo.adapter.repository.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
data class MobileNumberDTO(
    @DynamoDBAttribute
    var countryCode: String = "",

    @DynamoDBAttribute
    var number: String = ""
)
