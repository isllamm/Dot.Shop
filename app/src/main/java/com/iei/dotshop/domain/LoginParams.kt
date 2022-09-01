package com.iei.dotshop.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginParams(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("social_id")
    var socialId: String? = null
) : Parcelable
