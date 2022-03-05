package com.carriyo.carriyodemo.adapter.repository.interfaces

import com.carriyo.carriyodemo.adapter.repository.model.UserDTO

interface UserRepository {
    fun getUser(userId: String) : UserDTO
    fun addUser(user: UserDTO): UserDTO
    fun updateUser(user: UserDTO): UserDTO
    fun deleteUser(userId: String)
}
