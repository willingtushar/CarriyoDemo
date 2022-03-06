package com.carriyo.carriyodemo.adapter.repository.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDbConfiguration {
    @Bean
    fun dynamoDBMapper(): DynamoDBMapper {
        return DynamoDBMapper(buildAmazonDynamoDB())
    }

    private fun buildAmazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(
                    "dynamodb.ap-south-1.amazonaws.com",
                    "ap-south-1"
                )
            )
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(
                        "AKIAXMYTLPHNF6IPEIGQ",
                        "wQWl6sW5Golyhq2hck3IyMTGqMWWEUFRSpnHMg7s"
                    )
                )
            )
            .build()
    }
}
