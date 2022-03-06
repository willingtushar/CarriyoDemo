package com.carriyo.carriyodemo.adapter.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue
import com.carriyo.carriyodemo.adapter.repository.interfaces.UserRepository
import com.carriyo.carriyodemo.adapter.repository.model.UserDTO
import com.carriyo.carriyodemo.utils.DynamoDBInternalServerException
import com.carriyo.carriyodemo.utils.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepository:  UserRepository{
    @Autowired
    private val dynamoDBMapper: DynamoDBMapper? = null

    override fun getUser(userId: String): UserDTO {
        return try{
            getUserFromElasticSearch(userId)
        }catch(e: Exception){
            getUserFromDynamoDB(userId)
        }
    }

    override fun addUser(user: UserDTO): UserDTO {
        try {
            dynamoDBMapper!!.save(user)
            return user
        }catch (e: Exception){
            throw DynamoDBInternalServerException()
        }
    }

    override fun updateUser(user: UserDTO): UserDTO {
        // check if user exists
        try {
            dynamoDBMapper!!.load(UserDTO::class.java, user.userId) ?: throw UserNotFoundException()
        }
        catch (e: Exception){
            when(e){
                is UserNotFoundException -> throw e
                else -> throw DynamoDBInternalServerException()
            }
        }

        // update
        try {
            dynamoDBMapper.save(
                user,
                DynamoDBSaveExpression()
                    .withExpectedEntry(
                        "userid",
                        ExpectedAttributeValue(
                            AttributeValue().withS(user.userId)
                        )
                    )
            )
        }
        catch (e: Exception){
            throw DynamoDBInternalServerException()
        }
        return user
    }

    override fun deleteUser(userId: String) {
        try {
            val userEntryInDB = dynamoDBMapper!!.load(UserDTO::class.java, userId) ?: throw UserNotFoundException()
            dynamoDBMapper.delete(userEntryInDB)
        }
        catch (e: Exception){
            when(e){
                is UserNotFoundException -> throw e
                else -> throw DynamoDBInternalServerException()
            }
        }
    }

    private fun getUserFromDynamoDB(userId: String): UserDTO {
        try {
            return dynamoDBMapper!!.load(UserDTO::class.java, userId) ?: throw UserNotFoundException()
        }
        catch (e: Exception){
            when(e){
                is UserNotFoundException -> throw e
                else -> throw DynamoDBInternalServerException()
            }
        }
    }
    private fun getUserFromElasticSearch(userId: String): UserDTO {
        throw NotImplementedError()
    }
}
