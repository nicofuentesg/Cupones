package com.example.cupones

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.cupones.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateClass {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText("")))  //verifica que (view)(coincida con el texto que pusimos("")
        etCoupon.perform(click())
        etCoupon.perform(replaceText("Welcome_02"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(isDisplayed()))

        val etDescription = onView(withId(R.id.etDescription))
        etDescription.perform(click())
        etDescription.perform(replaceText("Cupon de 10% de descuento"))
        btnCreate.perform(click())

        //Para acceder al snackbar utilizamos la siguiente funcion
        val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbar.check(matches(withText("El cupón ya existe")))


    }
    /*
    * Verrificamos que el boton "crear" no exista y que no sea visible.
    * Test:Nuestro etCoupon inicia Vacio, luego haz click sobre el, añadimos el texto "Welcome_01"
    * y ahora desde btnConsult hacemos click sobre el.
    * Verificamos que el btnCrear no sea visible
    * */
    @Test
    fun couponExist(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText("")))  //verifica que (view)(coincida con el texto que pusimos("")
        etCoupon.perform(click())
        etCoupon.perform(replaceText("Welcome_01"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(not(isDisplayed())))


    }
    /*
    * Comprobamos que no se pueda repetir un cupon
    * */

    @Test
    fun couponRepeat(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText("")))  //verifica que (view)(coincida con el texto que pusimos("")
        etCoupon.perform(click())
        etCoupon.perform(replaceText("Welcome_01a"))

        val btnConsult = onView(withId(R.id.btnConsult))
        btnConsult.perform(click())

        val btnCreate = onView(withId(R.id.btnCreate))
        btnCreate.check(matches(isDisplayed()))

        val etDescription = onView(withId(R.id.etDescription))
        etDescription.check(matches(withText("")))
        etDescription.perform(click())
        etDescription.perform(replaceText("descuento del 10%"))

        etCoupon.perform(click())
        etCoupon.perform(replaceText("Welcome_01"))



        btnCreate.perform(click())

       /*  val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))

        snackbar.check(matches(withText("El cupón ya existe")))*/



    }


}