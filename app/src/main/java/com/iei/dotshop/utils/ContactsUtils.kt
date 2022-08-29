package com.iei.dotshop.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.databinding.ktx.BuildConfig
import com.facebook.shimmer.BuildConfig.APPLICATION_ID


fun makePhoneCall(context: Context, phone: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel: $phone")
    context.startActivity(intent)
}

fun openWhatsApp(context: Context, phone: String) {
    val url = "https://api.whatsapp.com/send?phone=$phone"
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    context.startActivity(i)
}


fun composeEmail(context: Context, addresses: Array<String?>?) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:") // only email apps should handle this
    intent.putExtra(Intent.EXTRA_EMAIL, addresses)
    intent.putExtra(Intent.EXTRA_SUBJECT, "Contact Us")
    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Log.d("7imaZz", "composeEmail: ${e.message}")
    }
}

fun visitWebsite(context: Context, url: String) {
    try {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(browserIntent)
    } catch (e: Exception) {
        ToastUtils.showToast(context, e.message.toString())
    }
}

fun shareApp(context: Context) {
    try {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Parking")
        var shareMessage = "\nLet me recommend you this application\n\n"
        /*shareMessage =
            """
            ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}

            
            """.trimIndent()*/
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        context.startActivity(Intent.createChooser(shareIntent, "choose one"))
    } catch (e: Exception) {
        Log.d("7imaZz", "shareApp: ${e.message}")
    }
}