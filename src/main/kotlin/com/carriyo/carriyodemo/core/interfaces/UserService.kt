package com.carriyo.carriyodemo.core.interfaces

import com.carriyo.carriyodemo.host.model.request.user.User

interface UserService {
    fun getUser(mobileNumber: String): User
    fun addUser(user: User): User
    fun updateUser(user: User): User
    fun deleteUser(mobileNumber: String)
}
