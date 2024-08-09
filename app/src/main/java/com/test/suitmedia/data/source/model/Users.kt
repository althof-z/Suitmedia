package com.test.suitmedia.data.source.model

import com.google.gson.annotations.SerializedName

data class Users(
    val id: Int,
    val avatar: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
)