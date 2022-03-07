package com.carriyo.carriyodemo.adapter.repository.config

import com.amazonaws.auth.AWS4Signer
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.carriyo.carriyodemo.adapter.repository.model.UserDTO
import com.carriyo.carriyodemo.adapter.repository.translator.UserDTOResponseTranslator.deSerializeResponse
import com.carriyo.carriyodemo.utils.UserNotFoundException
import org.apache.http.HttpHost
import org.apache.http.HttpRequestInterceptor
import org.opensearch.action.get.GetResponse
import org.opensearch.client.RequestOptions
import org.opensearch.client.RestClient
import org.opensearch.client.RestHighLevelClient


object ESClient {
    private const val serviceName = "es"
    private const val region = "ap-south-1"
    private const val index = "lambda-index"

    fun getUser(id: String): UserDTO{
        val searchClient: RestHighLevelClient = getESClient(serviceName, region)
        val request = org.opensearch.action.get.GetRequest(index, id)
        val response: GetResponse = searchClient.get(request, RequestOptions.DEFAULT)

        if(response.source == null)
            throw UserNotFoundException()

        return deSerializeResponse(response.source)
    }

    private fun getESClient(serviceName: String, region: String): RestHighLevelClient {
        val signer = AWS4Signer()
        signer.serviceName = serviceName
        signer.regionName = region
        val interceptor: HttpRequestInterceptor = AWSRequestSigningApacheInterceptor(
            serviceName,
            signer,
            AWSStaticCredentialsProvider(
                BasicAWSCredentials(
                    "AKIAXMYTLPHNF6IPEIGQ",
                    "wQWl6sW5Golyhq2hck3IyMTGqMWWEUFRSpnHMg7s"
                )
            )
        )
        val host = "https://search-carriyo-es-lt7cgh3srz3tlchj4qqlg5ddoe.ap-south-1.es.amazonaws.com"
        val restClient =  RestClient.builder(HttpHost.create(host))
            .setHttpClientConfigCallback { hacb ->
                hacb.addInterceptorLast(
                    interceptor
                )
            }
        return RestHighLevelClient(restClient)
    }
}
