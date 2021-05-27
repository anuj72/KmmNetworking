package com.example.mytestkmm

import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.*

expect class Platform() {
    val platform: String
}

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

expect fun initLogger()

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}