package com.test.suitmedia.data.source.model

data class reqresResponse(
    val page: Long,
    val perPage: Long,
    val total: Long,
    val totalPages: Long,
    val data: List<Users>,
)

