package com.carriyo.carriyodemo.adapter.database

import com.carriyo.carriyodemo.adapter.database.interfaces.UserRepository
import com.carriyo.carriyodemo.adapter.database.model.UserDTO
import com.carriyo.carriyodemo.utils.UserAlreadyExistedException
import com.carriyo.carriyodemo.utils.UserNotFoundException
import org.springframework.stereotype.Repository

@Repository
class MockUserRepository : UserRepository {
    private val userList : MutableList<UserDTO> = mutableListOf()

    override fun getUser(mobileNumber: String): UserDTO {
        val userResult = userList.find {
            it.mobileNumber.number == mobileNumber
        }
        return userResult ?: throw UserNotFoundException()
    }

    override fun addUser(user: UserDTO): UserDTO {
        val userEntryInDB = userList.find {
            it.mobileNumber.number == user.mobileNumber.number
        }
        if(userEntryInDB != null)
            throw UserAlreadyExistedException()

        userList.add(user)
        return user
    }

    override fun updateUser(user: UserDTO): UserDTO {
        val userEntryInDB = getUser(user.mobileNumber.number)

        userList.remove(userEntryInDB)
        userList.add(user)
        return user
    }

    override fun deleteUser(mobileNumber: String) {
        val userEntryInDB = getUser(mobileNumber)

        userList.remove(userEntryInDB)
    }
}
