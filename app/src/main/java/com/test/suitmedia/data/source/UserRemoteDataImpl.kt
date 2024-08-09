package com.test.suitmedia.data.source

import android.util.Log
import com.test.suitmedia.data.toUser
import com.test.suitmedia.data.model.User

class UserRemoteDataImpl(private val reqresService: ReqresService): UserRemoteData {
    override suspend fun fetchData(): List<User> {
        Log.d("pecing","now")
        val users= reqresService.getUsers(1,10).data.map{ it.toUser() }
        Log.d("FETCH", users.toString())
        return users
    }
}