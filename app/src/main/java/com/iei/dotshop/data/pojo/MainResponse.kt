package com.iei.dotshop.data.pojo

data class MainResponse<T>(
    val status: Boolean,
    val msg: String,
    val data: T?
)