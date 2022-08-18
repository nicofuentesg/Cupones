package com.example.cupones.common.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cupones.common.entities.CouponEntity

@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDataBase: RoomDatabase() {
    abstract fun couponDao(): CouponDao
}