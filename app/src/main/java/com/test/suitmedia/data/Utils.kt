package com.test.suitmedia.data

import com.test.suitmedia.data.source.model.Users
import com.test.suitmedia.data.model.User

fun Users.toUser(): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        avatar = avatar
    )
}