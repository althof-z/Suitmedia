package com.test.suitmedia.domain

import com.test.suitmedia.data.model.User

interface ReqresRepository {
    suspend fun fetchData(): List<User>
}