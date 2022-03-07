package com.carriyo.carriyodemo.adapter.repository.translator

import com.carriyo.carriyodemo.adapter.repository.model.AddressDTO
import com.carriyo.carriyodemo.adapter.repository.model.AddressTagDTO
import com.carriyo.carriyodemo.adapter.repository.model.MobileNumberDTO
import com.carriyo.carriyodemo.adapter.repository.model.UserDTO

object UserDTOResponseTranslator {

    fun deSerializeResponse(source: Map<String, Any>): UserDTO {
        val firstName = source["firstName"] ?: ""
        val lastName = source["lastName"] ?: ""
        val email = source["email"] ?: ""
        val id = source["userId"] ?: ""

        val sourceMobileNumber = source["mobileNumber"] as Map<*, *>
        val countryCode = sourceMobileNumber["countryCode"] ?: ""
        val number = sourceMobileNumber["number"] ?: ""

        val sourceAddresses = source["addresses"] as ArrayList<*>
        val addresses : MutableList<AddressDTO> = mutableListOf()
        for(sourceAddress in sourceAddresses){
            addresses.add(deserializeAddress(sourceAddress))
        }
        return UserDTO(
            firstName = firstName as String,
            lastName = lastName as String,
            email = email as String,
            userId = id as String,
            mobileNumber = MobileNumberDTO(countryCode = countryCode as String, number = number as String),
            addresses = addresses
        )
    }

    private fun deserializeAddress(sourceAddress: Any): AddressDTO {
        sourceAddress as HashMap<*,*>
        val addressLine1 = sourceAddress["addressLine1"] ?: ""
        val addressLine2 = sourceAddress["addressLine2"]
        val addressLine3 = sourceAddress["addressLine3"]
        val city = sourceAddress["city"] ?:""
        val state = sourceAddress["state"]?:""
        val country = sourceAddress["country"] ?:""
        val postalCode = sourceAddress["postalCode"] ?:""
        val landmark = sourceAddress["landmark"] ?:""

        val sourceTags = sourceAddress["addressTags"] as ArrayList<*>
        val addressTags = mutableListOf<AddressTagDTO>()
        for(sourceTag in sourceTags){
            val tag = when(sourceTag){
                "HOME" -> AddressTagDTO.HOME
                "COMMUNICATION" -> AddressTagDTO.COMMUNICATION
                else -> AddressTagDTO.WORK
            }
            addressTags.add(tag)
        }

        return AddressDTO(
            addressLine1 = addressLine1 as String,
            addressLine2 = addressLine2 as String,
            addressLine3 = addressLine3 as String,
            landmark = landmark as String,
            postalCode = postalCode as String,
            city = city as String,
            state = state as String,
            country = country as String,
            addressTags = addressTags
        )
    }
}
