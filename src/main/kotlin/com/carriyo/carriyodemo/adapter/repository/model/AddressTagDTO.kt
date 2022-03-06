package com.carriyo.carriyodemo.adapter.repository.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum

@DynamoDBTypeConvertedEnum
enum class AddressTagDTO{
    COMMUNICATION,
    HOME,
    WORK
}

