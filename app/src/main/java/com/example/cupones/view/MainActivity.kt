package com.example.cupones.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cupones.BR
import com.example.cupones.R
import com.example.cupones.common.entities.CouponEntity
import com.example.cupones.common.utils.hideKeyboard
import com.example.cupones.databinding.ActivityMainBinding
import com.example.cupones.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setupBotton()
        setupViewModel()
        setupObserver()

    }

    private fun setupObserver() {

        binding.viewModel?.let {

            it.coupon.observe(this,{
                binding.isActive = it != null && it.isActive

            })

           it.getSnackBarMsg().observe(this,{msg ->
                Snackbar.make(binding.root,msg, Snackbar.LENGTH_SHORT).show()
            })

            it.getHideKeyboard().observe(this,{ isHide ->
                if (isHide) hideKeyboard(this,binding.root)

            })
        }
    }

    private fun setupViewModel() {
    binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)

    }

    /*private fun setupBotton() {
        binding.btnConsult.setOnClickListener {
            hideKeyboard(this, binding.root)
         //   viewModel.consultCouponByCode(binding.etCoupon.text.toString())
        }

        binding.btnCreate.setOnClickListener {
            val coupon = CouponEntity(code = binding.etCoupon.text.toString(),
                description = binding.etDescription.text.toString())
            hideKeyboard(this, binding.root)

           // viewModel.saveCoupon(coupon)
        }
    }*/
}