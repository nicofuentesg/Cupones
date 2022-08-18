package com.example.cupones.model

import android.database.sqlite.SQLiteConstraintException
import com.example.cupones.CouponsApplication
import com.example.cupones.common.dataBase.CouponDao
import com.example.cupones.common.entities.CouponEntity
import com.example.cupones.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RoomDataBase {

    private val dao: CouponDao by lazy { CouponsApplication.dataBase.couponDao() }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponByCode(code)

    suspend fun saveCoupon(couponDao: CouponEntity) = withContext(Dispatchers.IO){
        try {
            dao.addCoupon(couponDao)
        }catch (e: Exception){
            (e as? SQLiteConstraintException)?.let { throw Exception(Constants.ERROR_EXIST) }
            throw  Exception(e.message ?: Constants.unknownError)
        }

    }



}