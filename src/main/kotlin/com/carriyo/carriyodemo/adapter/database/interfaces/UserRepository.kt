package com.carriyo.carriyodemo.adapter.database.interfaces

import com.carriyo.carriyodemo.adapter.database.model.UserDTO

interface UserRepository {
    fun getUser(mobileNumber: String) : UserDTO
    fun addUser(user: UserDTO): UserDTO
    fun updateUser(user: UserDTO): UserDTO
    fun deleteUser(mobileNumber: String)
}
