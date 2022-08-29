package com.iei.dotshop.utils

import android.app.AlertDialog
import android.content.Context
import com.iei.dotshop.R

fun showAlertDialog(context: Context, title: String, msg: String) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(msg)
        .setPositiveButton(context.getString(R.string.ok)) { d, _ ->
            d.dismiss()
        }
    val alert: AlertDialog = builder.create()
    alert.show()
}

fun choiceAlertDialog(context: Context, title: String, msg: String, action: () -> Unit){
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(msg)
        .setPositiveButton(context.getString(R.string.yes)) { _, _ ->
            action()
        }
        .setNegativeButton(context.getString(R.string.no)) { d, _ ->
            d.dismiss()
        }
    val alert: AlertDialog = builder.create()
    alert.show()

}
