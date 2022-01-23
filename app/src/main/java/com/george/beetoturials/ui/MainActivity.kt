package com.george.beetoturials.ui

import com.george.beetoturials.base.BaseActivity
import com.george.beetoturials.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    override val TAG: String get() = this.javaClass.name

    override fun beforeCreatingView() {}

    override fun initialization() {}

    override fun setListener() {}

}