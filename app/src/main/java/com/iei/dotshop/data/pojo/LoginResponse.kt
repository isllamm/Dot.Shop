package com.iei.dotshop.data.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("user")
    val userDataResponse: UserDataResponse? = null,
) : Parcelable

@Parcelize
data class UserDataResponse(
    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("app_type")
    val appType: Int? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("gender")
    val gender: Int? = null,

    @field:SerializedName("lng")
    val lng: String? = null,

    @field:SerializedName("jwt_token")
    val jwtToken: String? = null,

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("dob")
    val dob: String? = null,

    @field:SerializedName("qr_code")
    val qrCodeImage: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("lat")
    val lat: String? = null,

    @field:SerializedName("ID_number")
    val idNumber: String? = null,

    @field:SerializedName("firebase_token")
    val firebaseToken: String? = null,

    @field:SerializedName("city_id")
    val cityId: Int? = null,

    @field:SerializedName("country_id")
    val countryId: Int? = null,

    @field:SerializedName("crystals_count")
    val crystalsCount: Long? = null,

    @field:SerializedName("interest_ids")
    val interests: List<Int?>? = null,

    @field:SerializedName("category_ids")
    val categories: List<Int?>? = null,
) : Parcelable

