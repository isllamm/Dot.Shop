package com.horizons.minute.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    val id: Int,
    val active: Int,
    val address: Any,
    val balance: Int,
    @SerializedName("country_code")
    val countryCode: String,
    val email: String,
    @SerializedName("fcm_token")
    val fcmToken: String?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val image: String,
    val locale: String,
    @SerializedName("mobile_id")
    val mobileId: Int?,
    val notifiable: Int,
    val phone: String,
    @SerializedName("referral_code")
    val referralCode: String,
    val status: Int,
    val token: String
): Serializable