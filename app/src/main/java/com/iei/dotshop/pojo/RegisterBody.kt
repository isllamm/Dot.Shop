package com.iei.dotshop.pojo

import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
    @SerializedName("country_code")
    val countryCode: String,
    val phone: String,
    val password: String,
    @SerializedName("referral_code")
    val referralCode: String = ""
)
