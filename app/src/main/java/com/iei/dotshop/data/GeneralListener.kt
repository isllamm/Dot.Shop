package com.iei.dotshop.data

interface GeneralListener<T> {
    fun getApiResponse(
        status: Int, message: String?,
        tApiResponse: T
    )
}



