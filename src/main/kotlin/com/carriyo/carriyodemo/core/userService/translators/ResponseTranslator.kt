package com.carriyo.carriyodemo.core.userService.translators

import com.carriyo.carriyodemo.adapter.repository.model.AddressDTO
import com.carriyo.carriyodemo.adapter.repository.model.AddressTagDTO
import com.carriyo.carriyodemo.adapter.repository.model.MobileNumberDTO
import com.carriyo.carriyodemo.adapter.repository.model.UserDTO
import com.carriyo.carriyodemo.host.model.request.user.Address
import com.carriyo.carriyodemo.host.model.request.user.AddressTag
import com.carriyo.carriyodemo.host.model.request.user.MobileNumber
import com.carriyo.carriyodemo.host.model.request.user.User

object ResponseTranslator {
    fun toModel(userDto: UserDTO): User {
        return User(
            userId = userDto.userId,
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            email = userDto.email,
            mobileNumber = getMobileNumber(userDto.mobileNumber),
            addresses = getAddresses(userDto.addresses)
        )
    }

    private fun getAddresses(addressesDto: List<AddressDTO>): List<Address> {
        val addresses = mutableListOf<Address>()
        addressesDto.forEach{
            addresses.add(getAddress(it))
        }
        return addresses
    }

    private fun getAddress(addressDTO: AddressDTO): Address {
        return Address(
            addressLine1 = addressDTO.addressLine1,
            addressLine2 = addressDTO.addressLine2,
            addressLine3 = addressDTO.addressLine3,
            landmark = addressDTO.landmark,
            postalCode = addressDTO.postalCode,
            city = addressDTO.city,
            state = addressDTO.state,
            country = addressDTO.country,
            addressTags = getAddressTags(addressDTO.addressTags)
        )
    }

    private fun getAddressTags(addressDtoTags: List<AddressTagDTO>): List<AddressTag> {
        val addressTags = mutableListOf<AddressTag>()
        addressDtoTags.forEach{
            addressTags.add(getAddressTag(it))
        }
        return addressTags
    }

    private fun getAddressTag(addressDtoTag: AddressTagDTO): AddressTag {
        return when(addressDtoTag){
            AddressTagDTO.WORK -> AddressTag.WORK
            AddressTagDTO.COMMUNICATION -> AddressTag.COMMUNICATION
            AddressTagDTO.HOME -> AddressTag.HOME
        }
    }

    private fun getMobileNumber(mobileNumber: MobileNumberDTO): MobileNumber {
        return MobileNumber(
            countryCode = mobileNumber.countryCode,
            number = mobileNumber.number
        )
    }
}
