package com.george.beetoturials.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B
) : AppCompatActivity() {

    abstract val TAG: String
    val binding: B by lazy { bindingFactory(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeCreatingView()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialization() // get FCM ID
        setListener()
    }

    abstract fun beforeCreatingView()
    abstract fun initialization()
    abstract fun setListener()


}