package com.iei.dotshop.data.remote


import com.iei.dotshop.data.ErrorResponse
import com.iei.dotshop.data.pojo.LoginResponse
import com.iei.dotshop.data.pojo.UserResponse
import com.iei.dotshop.data.pojo.MainResponse
import com.iei.dotshop.data.pojo.RegisterBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    companion object {
        const val BASE_URL = ""
    }
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("phone") phone : String,
        @Field("pass") pass : String): NetworkResponse<BaseResponse<LoginResponse>, ErrorResponse>

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
    ): Response<MainResponse<UserResponse>>/*
    @POST("login")
    suspend fun login(
      @Field("phone") phone : String,
      @Field("pass") pass : String): Response<UserModel>

    @POST("register")
    suspend fun register(
        @Field("phone") phone : String,
        @Field("pass") pass : String,
        @Field("email") email : String)  : Response<UserModel>*/
}
