package com.carriyo.carriyodemo.adapter.repository.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@DynamoDBTable(tableName = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
data class UserDTO(
    @DynamoDBHashKey(attributeName = "userid")
    var userId: String = "",

    @DynamoDBAttribute
    var firstName: String = "",

    @DynamoDBAttribute
    var lastName: String? = null,

    @DynamoDBAttribute
    var email: String = "",

    @DynamoDBAttribute
    var mobileNumber: MobileNumberDTO = MobileNumberDTO("",""),

    @DynamoDBAttribute
    var addresses: List<AddressDTO> = emptyList()
){

}
