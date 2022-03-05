package com.carriyo.carriyodemo.host.controllers

import com.carriyo.carriyodemo.core.userService.UserServices
import com.carriyo.carriyodemo.host.model.Constants.userDeletedMessage
import com.carriyo.carriyodemo.host.model.Constants.v1BaseUrl
import com.carriyo.carriyodemo.host.model.request.Request
import com.carriyo.carriyodemo.host.model.request.user.User
import com.carriyo.carriyodemo.host.model.response.SuccessResponse
import com.carriyo.carriyodemo.host.model.response.user.DeleteUserResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(v1BaseUrl)
@Validated
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
        @Valid @RequestBody addUserRequest: Request<User>
    ): SuccessResponse<User> {
        val response = userServices.addUser(addUserRequest.data)
        return SuccessResponse(response)
    }

    @PutMapping("/user")
    fun updateUser(
        @Valid @RequestBody updateUserRequest: Request<User>
    ): SuccessResponse<User> {
        val response = userServices.updateUser(updateUserRequest.data)
        return SuccessResponse(response)
    }

    @DeleteMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteUser(
        @PathVariable userId: String
    ): SuccessResponse<DeleteUserResponse> {
        userServices.deleteUser(userId)
        return SuccessResponse(DeleteUserResponse(userDeletedMessage))
    }
}
