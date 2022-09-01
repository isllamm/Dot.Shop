package com.iei.dotshop.data.repository

import com.iei.dotshop.data.ErrorResponse
import com.iei.dotshop.data.pojo.LoginResponse
import com.iei.dotshop.data.pojo.RegisterBody
import com.iei.dotshop.data.remote.ApiInterface
import com.iei.dotshop.data.remote.BaseResponse
import com.iei.dotshop.data.remote.NetworkResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiInterface) {
    suspend fun login(email :String , pass :String): NetworkResponse<BaseResponse<LoginResponse>, ErrorResponse> {
        return api.login(email,pass)
    }
/* @POST("LOGIN")
    suspend fun login(@Body loginParams: LoginParams?): NetworkResponse<BaseResponse<LoginResponse>, ErrorResponse>
   */
    /*suspend fun register(registerBody: RegisterBody) =
        api.register(PrefsHelper.getLanguage(), registerBody)
*/

   /* suspend fun login(countryCode: String, phone: String, password: String) =
        api.login(PrefsHelper.getLanguage(), countryCode, phone, password)*/
}
