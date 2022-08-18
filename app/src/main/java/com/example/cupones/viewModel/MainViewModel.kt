package com.example.cupones.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cupones.R
import com.example.cupones.common.entities.CouponEntity
import com.example.cupones.common.utils.getErrorMessage
import com.example.cupones.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = MainRepository()



     val coupon = MutableLiveData(CouponEntity())


    private val hideKeyboard = MutableLiveData<Boolean>()
    fun getHideKeyboard() = hideKeyboard


    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackBarMsg() = snackbarMsg

   /* fun consultCouponByCodeOld(code: String){
        viewModelScope.launch {
            result.value = repository.consultCouponByCode(code)
        }
    }*/
    fun consultCouponByCode(){
        coupon.value?.code?.let { code->
            viewModelScope.launch {
                hideKeyboard.value = true
                coupon.value = repository.consultCouponByCode(code) ?: CouponEntity(code = code, isActive = false)
            }

        }

        }
/*
    fun saveCouponOld(couponEntity: CouponEntity){
        viewModelScope.launch {
            try {
                repository.saveCoupon(couponEntity)
                consultCouponByCode(couponEntity.code)
                snackbarMsg.value = R.string.save_cupon
            } catch (e: Exception) {
                snackbarMsg.value = getErrorMessage(e.message)
            }
        }
    }*/
    fun saveCoupon(){
        coupon.value?.let { coupons->

            viewModelScope.launch {
                try {
                    coupons.isActive = true
                    hideKeyboard.value = true
                    repository.saveCoupon(coupons)
                    consultCouponByCode()
                    snackbarMsg.value = R.string.save_cupon
                } catch (e: Exception) {
                    snackbarMsg.value = getErrorMessage(e.message)
                }
            }

        }
    }
}