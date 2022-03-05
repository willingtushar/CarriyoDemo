package com.carriyo.carriyodemo.core.userService

import com.carriyo.carriyodemo.adapter.repository.interfaces.UserRepository
import com.carriyo.carriyodemo.core.interfaces.UserService
import com.carriyo.carriyodemo.core.userService.translators.RequestTranslator.checkForUserId
import com.carriyo.carriyodemo.core.userService.translators.RequestTranslator.validateAndTranslate
import com.carriyo.carriyodemo.core.userService.translators.ResponseTranslator.toModel
import com.carriyo.carriyodemo.host.model.request.user.User
import org.springframework.stereotype.Service

@Service
class UserServices(
    val userRepository: UserRepository
) : UserService {
    override fun getUser(userId: String): User {
        val dbResponse = userRepository.getUser(userId)
        return toModel(dbResponse)
    }

    override fun addUser(user: User): User {
        // 1. validate and translate
        val userDto = validateAndTranslate(user)

        // 2. call db
        val dbResponse = userRepository.addUser(userDto)

        // 3. translate db response
        return toModel(dbResponse)
    }

    override fun updateUser(user: User): User {
        // 1. validate and translate
        checkForUserId(user)
        val userDto = validateAndTranslate(user)

        // 2. call db
        val dbResponse = userRepository.updateUser(userDto)

        // 3. translate db response
        return toModel(dbResponse)
    }

    override fun deleteUser(userId: String) {
        userRepository.deleteUser(userId)
    }
}
