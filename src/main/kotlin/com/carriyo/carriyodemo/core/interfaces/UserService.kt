package com.carriyo.carriyodemo.core.interfaces

import com.carriyo.carriyodemo.host.model.request.user.User

interface UserService {
    fun getUser(userId: String): User
    fun addUser(user: User): User
    fun updateUser(user: User): User
    fun deleteUser(userId: String)
}
