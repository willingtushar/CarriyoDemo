package com.carriyo.carriyodemo.host.controllers

import com.carriyo.carriyodemo.core.userService.UserServices
import com.carriyo.carriyodemo.host.model.Constants.userDeletedMessage
import com.carriyo.carriyodemo.host.model.Constants.v1BaseUrl
import com.carriyo.carriyodemo.host.model.request.Request
import com.carriyo.carriyodemo.host.model.request.user.User
import com.carriyo.carriyodemo.host.model.response.SuccessResponse
import com.carriyo.carriyodemo.host.model.response.user.DeleteUserResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(v1BaseUrl)
class UserController(
    private val userServices: UserServices
) {
    @GetMapping("/user/{userId}")
    fun getUser(
        @PathVariable userId: String
    ): SuccessResponse<User> {
        val response = userServices.getUser(userId)
        return SuccessResponse(response)
    }

    @PostMapping("/user")
    fun addUser(
        @RequestBody addUserRequest: Request<User>
    ): SuccessResponse<User> {
        val response = userServices.addUser(addUserRequest.data)
        return SuccessResponse(response)
    }

    @PutMapping("/user")
    fun updateUser(
        @RequestBody updateUserRequest: Request<User>
    ): SuccessResponse<User> {
        val response = userServices.updateUser(updateUserRequest.data)
        return SuccessResponse(response)
    }

    @DeleteMapping("/user/{mobileNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteUser(
        @PathVariable mobileNumber: String
    ): SuccessResponse<DeleteUserResponse> {
        userServices.deleteUser(mobileNumber)
        return SuccessResponse(DeleteUserResponse(userDeletedMessage))
    }
}
