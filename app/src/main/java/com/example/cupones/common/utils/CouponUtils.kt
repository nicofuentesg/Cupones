package com.example.cupones.common.utils

import android.content.Context
import android.view.InputDevice
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.cupones.R

fun validatelenghtCoupons(code: String): Boolean{
    return !(code.length < 5 || code.length > 10)
}

fun getErrorMessage(errorCode: String?): Int = when(errorCode){
    Constants.ERROR_EXIST -> R.string.error_unique_code
    Constants.ERROR_LENGHT -> R.string.error_lenght_code
    else-> R.string.error_unkown_code
}

fun hideKeyboard(context: Context,view: View){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)

}
