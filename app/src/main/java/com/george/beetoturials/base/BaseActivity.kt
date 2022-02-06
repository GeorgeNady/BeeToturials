package com.george.beetoturials.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.george.beetoturials.R
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B
) : AppCompatActivity() {

    abstract val TAG: String
    val binding: B by lazy { bindingFactory(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Hosha)
        beforeCreatingView()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialization()
        setListener()
    }

    abstract fun beforeCreatingView()
    abstract fun initialization()
    abstract fun setListener()

    fun setupNavController(navHostFragment: Int): NavController {
        val nhf = supportFragmentManager.findFragmentById(navHostFragment) as NavHostFragment
        return nhf.navController
    }


}