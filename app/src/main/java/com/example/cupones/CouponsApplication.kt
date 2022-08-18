package com.example.cupones

import android.app.Application
import androidx.room.Room
import com.example.cupones.common.dataBase.CouponDataBase

class CouponsApplication: Application() {
    companion object{
        lateinit var dataBase: CouponDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(this,
            CouponDataBase::class.java,
            "CouponDataBase")
            .build()
    }
}