package com.test.suitmedia.data.source

import com.test.suitmedia.data.source.model.reqresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): reqresResponse
}
