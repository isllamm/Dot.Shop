package com.iei.dotshop.utils

import java.util.*

fun Float?.toOneDecimalPoint(): String {
    if (this != null) {
        val s = "%.${2}f".format(Locale(Constants.EN), this).toFloat().toString()
        if (s[s.indexOf(".") + 1] == '0') {
            return s.substringBefore(".")
        }
        return s
    }
    return "0.0"
}