package com.example.cupones.model

import com.example.cupones.common.entities.CouponEntity
import com.example.cupones.common.utils.Constants
import com.example.cupones.common.utils.validatelenghtCoupons

class MainRepository {

    private val roomDataBase = RoomDataBase()

    suspend fun consultCouponByCode(code: String) = roomDataBase.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity){
        if(validatelenghtCoupons(couponEntity.code)){
            roomDataBase.saveCoupon(couponEntity)
        }else{
            throw Exception(Constants.ERROR_LENGHT)
        }
    }
}