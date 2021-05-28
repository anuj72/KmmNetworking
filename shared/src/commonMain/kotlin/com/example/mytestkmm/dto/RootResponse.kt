package com.example.mytestkmm.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RootResponse(
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    val data: List<Data>
)
