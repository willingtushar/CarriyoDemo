package com.carriyo.carriyodemo.core.userService.translators

import com.carriyo.carriyodemo.adapter.database.model.AddressDTO
import com.carriyo.carriyodemo.adapter.database.model.AddressTagDTO
import com.carriyo.carriyodemo.adapter.database.model.MobileNumberDTO
import com.carriyo.carriyodemo.adapter.database.model.UserDTO
import com.carriyo.carriyodemo.host.model.request.user.Address
import com.carriyo.carriyodemo.host.model.request.user.AddressTag
import com.carriyo.carriyodemo.host.model.request.user.MobileNumber
import com.carriyo.carriyodemo.host.model.request.user.User

object RequestTranslator {
    fun validateAndTranslate(user: User): UserDTO{
        // todo: validations are remaining

        return UserDTO(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            mobileNumber = getMobileNumber(user.mobileNumber),
            addresses = getAddresses(user.addresses)
        )
    }

    private fun getAddresses(address: List<Address>): List<AddressDTO> {
        val addressDtos = mutableListOf<AddressDTO>()
        address.forEach {
            addressDtos.add(getAddress(it))
        }
        return addressDtos
    }

    private fun getAddress(address: Address): AddressDTO {
        return AddressDTO(
            addressLine1 = address.addressLine1,
            addressLine2 = address.addressLine2,
            addressLine3 = address.addressLine3,
            landmark = address.landmark,
            postalCode = address.postalCode,
            city = address.city,
            state = address.state,
            country = address.country,
            addressTags = getAddressTags(address.addressTags)
        )
    }

    private fun getAddressTags(addressTags: List<AddressTag>): List<AddressTagDTO> {
        val tagDtos = mutableListOf<AddressTagDTO>()
        addressTags.forEach{
            tagDtos.add(
                getAddressTag(it)
            )
        }
        return tagDtos
    }

    private fun getAddressTag(addressTag: AddressTag): AddressTagDTO {
        return when(addressTag){
            AddressTag.COMMUNICATION -> AddressTagDTO.COMMUNICATION
            AddressTag.HOME -> AddressTagDTO.HOME
            AddressTag.WORK -> AddressTagDTO.WORK
        }
    }

    private fun getMobileNumber(mobileNumber: MobileNumber): MobileNumberDTO {
        return MobileNumberDTO(
            countryCode = mobileNumber.countryCode,
            number = mobileNumber.number
        )
    }

}