package com.example.mytestkmm

import com.example.mytestkmm.dto.RootResponse
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class SampleApiClient {

    companion object {
        private const val URL = "https://reqres.in/api/users?page=1"
    }

    private val httpApiClient: HttpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getUsers(): RootResponse {
        return httpApiClient.get(URL)
    }
}