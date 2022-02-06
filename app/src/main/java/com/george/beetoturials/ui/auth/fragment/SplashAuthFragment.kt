package com.george.beetoturials.ui.auth.fragment

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import bee.bee.hoshaapp.base.ActivityFragmentAnnoation
import com.george.beetoturials.R
import com.george.beetoturials.base.fragments.BaseFragment
import com.george.beetoturials.databinding.FragmentSplashAuthBinding
import com.george.beetoturials.ui.auth.AuthActivity


@SuppressLint("NonConstantResourceId")
@ActivityFragmentAnnoation(R.layout.fragment_splash_auth)
class SplashAuthFragment : BaseFragment<FragmentSplashAuthBinding>() {

    override val TAG: String get() = this.javaClass.name

    override fun initViewModel() {}

    override fun setListener() {
        binding!!.apply {
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.loginFragment,)
            }
            /*btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }*/
        }
    }
}