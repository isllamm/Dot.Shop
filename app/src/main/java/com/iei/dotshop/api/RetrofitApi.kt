package com.iei.dotshop.api

import com.horizons.minute.pojo.UserResponse
import com.iei.dotshop.pojo.MainResponse
import com.iei.dotshop.pojo.RegisterBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitApi {
    companion object {
        const val BASE_URL = ""
    }

    @POST("user/register")
    suspend fun register(
        @Header("lang") lang: String,
        @Body registerBody: RegisterBody
    ): Response<MainResponse<UserResponse>>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Header("lang") lang: String,
        @Field("country_code")countryCode: String,
        @Field("phone") phone: String,
        @Field("password") password: String
    ): Response<MainResponse<UserResponse>>

}