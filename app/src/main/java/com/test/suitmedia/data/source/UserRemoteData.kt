package com.test.suitmedia.data.source

import com.test.suitmedia.data.model.User

interface UserRemoteData {
    suspend fun fetchData(): List<User>
}