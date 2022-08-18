package com.example.cupones.common.adapter

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.cupones.R

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone:Boolean){
    view.visibility = if(isGone) View.GONE else View.VISIBLE
}
@BindingAdapter("isNewCoupon")
fun bindText(view:TextView, active:Boolean){
    if (active){
        view.setText(R.string.main_text_coupons)
        view.setTextColor(Color.BLACK)
    }else{
        view.setText(R.string.main_text_coupons_new)
        view.setTextColor(Color.RED)
    }
}