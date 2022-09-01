package com.iei.dotshop.data.remote

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

data class BaseResponse<T>(
    @SerializedName("data")
    var data: @RawValue T? = null
) : BaseCommonResponse()

open class BaseCommonResponse(
    @SerializedName("status")
    var status: Int? = null,
    @SerializedName("message")
    var message: String? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(status)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    @SuppressLint("ParcelCreator")
    companion object CREATOR : Parcelable.Creator<BaseCommonResponse> {
        override fun createFromParcel(parcel: Parcel): BaseCommonResponse {
            return BaseCommonResponse(parcel)
        }

        override fun newArray(size: Int): Array<BaseCommonResponse?> {
            return arrayOfNulls(size)
        }
    }
}


enum class ServerStatusCodes(val code: Int) {
    SUCCESS(200),
    FAIL(401), //fail with message
    SOCIAL_REGISTER(402), //login with social and needs to complete data
    TOKEN_EXPIRED(403),
    ACTIVE_ACCOUNT(405),
}
