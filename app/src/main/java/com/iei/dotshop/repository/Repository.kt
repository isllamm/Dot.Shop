package com.iei.dotshop.repository

import com.iei.dotshop.api.RetrofitApi
import com.iei.dotshop.data.PrefsHelper
import com.iei.dotshop.pojo.RegisterBody
import javax.inject.Inject

class Repository
@Inject
constructor(private val api: RetrofitApi) {
    suspend fun register(registerBody: RegisterBody) =
        api.register(PrefsHelper.getLanguage(), registerBody)


    suspend fun login(countryCode: String, phone: String, password: String) =
        api.login(PrefsHelper.getLanguage(), countryCode, phone, password)
}
