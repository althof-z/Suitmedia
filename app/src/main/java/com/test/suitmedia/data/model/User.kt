package com.test.suitmedia.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val avatar: String,
    val firstName: String,
    val lastName: String,
    val email: String,
): Parcelable