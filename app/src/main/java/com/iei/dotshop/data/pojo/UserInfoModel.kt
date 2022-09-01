package com.iei.dotshop.data.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfoModel(
    var phone: String,
    val appType: Int,
    var jwtToken: String,
    val lastName: String,
    val id: Int,
    val firstName: String,
    val image: String,
    val qrCodeImage: String,
    val email: String,
    val address: String,
    val gender: Int,
    val lng: String,
    val dob: String,
    val lat: String,
    val idNumber: String,
    val cityId: Int,
    val countryId: Int,
    val crystalsCount: Long,
    val interests: List<Int>,
    val categories: List<Int>,
    val fcmToken: String
) : Parcelable