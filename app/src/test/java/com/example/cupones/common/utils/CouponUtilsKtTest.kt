package com.example.cupones.common.utils

import com.example.cupones.R
import org.junit.Assert.*
import org.junit.Test

class CouponUtilsKtTest{
    @Test
    fun validatelenghtCouponsSuccessTest(){
        val code = "WELCOME"
        assertTrue(validatelenghtCoupons(code))
    }
   @Test
    fun validatelenghtCouponsEmptyFailTest(){
        val code = ""
        assertFalse(validatelenghtCoupons(code))
    }
    @Test
    fun validateTextCodeMinLenghtFailTest(){
        val code = "Hola"
        assertFalse(validatelenghtCoupons(code))
    }
    @Test
    fun validateTextCodeMaxLenghtFailTest(){
        val code = "impresionante"
        assertFalse(validatelenghtCoupons(code))
    }
    @Test
    fun validateTextCodeMaxLenghtSuccessTest(){
        val code = "bestseller"
        assertTrue(validatelenghtCoupons(code))
    }
    @Test
    fun validateErrorNullMessage(){
        val errorCode = null
        val expectResult = R.string.error_unkown_code
        val result = getErrorMessage(errorCode)
        assertEquals("Error al validar el mensaje a null",result,expectResult)
    }
    @Test
    fun validateErrorCouponMessage(){
        val errorCode = Constants.ERROR_EXIST
        val expectResult = R.string.error_unique_code
        val result = getErrorMessage(errorCode)
        assertEquals("Error al validar el cupon ya existente",result,expectResult)
    }
    @Test
  fun validateErrorLengthMessage(){
        val errorCode = Constants.ERROR_LENGHT
        val expectResult =  R.string.error_lenght_code
        val result = getErrorMessage(errorCode)
        assertEquals("Error al validar el cupon ya existente",result,expectResult)
        //Ponemos -1 porque el valor de R siempre va a ser positivo
        assertNotEquals("Error al validar el cupon ya existente",-1,expectResult)
    }
    @Test
    fun checkGruopSuccessTest(){
        val aNames = arrayOf("Nicolas","Daniel","Pedro")
        val bNames = arrayOf("Nicolas","Daniel","Pedro")
        assertArrayEquals("Los arreglos deben ser iguales",aNames,bNames)

    }

    @Test
    fun checkGroupFailTest(){
        val aColors = arrayOf("Rojo","Verde","Azul")
        val bColors = arrayOf("Rojo","verde","Azul","Gris")
        assertNotEquals("Los arreglos no deberían ser iguales", aColors,bColors)
    }


}