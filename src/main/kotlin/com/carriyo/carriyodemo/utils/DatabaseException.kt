package com.carriyo.carriyodemo.utils

abstract class DatabaseException(override val message: String, open val fieldName: String) : Exception(message)

class UserNotFoundException : DatabaseException("No user is found in the database", "mobileNumber")
class UserAlreadyExisted : DatabaseException("User already existed in the database", "mobileNumber")

