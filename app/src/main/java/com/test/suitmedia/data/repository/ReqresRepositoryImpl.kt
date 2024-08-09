package com.test.suitmedia.data.repository

import coil.decode.DataSource
import com.test.suitmedia.data.model.User
import com.test.suitmedia.data.source.UserRemoteData
import com.test.suitmedia.domain.ReqresRepository

class ReqresRepositoryImpl(
    private val remoteDataSource: UserRemoteData
):ReqresRepository{
    override suspend fun fetchData(): List<User> {
        return remoteDataSource.fetchData()
    }
}