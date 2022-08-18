package com.example.cupones.common.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cupones.common.entities.CouponEntity

@Dao
interface CouponDao {

    @Query("SELECT * FROM CouponEntity where code = :code")
    suspend fun consultCouponByCode(code: String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long

}