package com.carriyo.carriyodemo.adapter.repository

import com.carriyo.carriyodemo.adapter.repository.interfaces.UserRepository
import com.carriyo.carriyodemo.adapter.repository.model.UserDTO
import com.carriyo.carriyodemo.utils.UserAlreadyExistedException
import com.carriyo.carriyodemo.utils.UserNotFoundException
import org.springframework.stereotype.Repository

@Repository
class MockUserRepository : UserRepository {
    private val userList : MutableList<UserDTO> = mutableListOf()

    override fun getUser(userId: String): UserDTO {
        val userResult = userList.find {
            it.userId == userId
        }
        return userResult ?: throw UserNotFoundException()
    }

    override fun addUser(user: UserDTO): UserDTO {
        userList.add(user)
        return user
    }

    override fun updateUser(user: UserDTO): UserDTO {
        val userEntryInDB = getUser(user.userId)

        userList.remove(userEntryInDB)
        userList.add(user)
        return user
    }

    override fun deleteUser(userId: String) {
        val userEntryInDB = getUser(userId)

        userList.remove(userEntryInDB)
    }
}
