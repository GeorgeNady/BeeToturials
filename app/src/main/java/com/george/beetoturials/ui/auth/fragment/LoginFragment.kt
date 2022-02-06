package com.george.beetoturials.ui.auth.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.lifecycle.lifecycleScope
import bee.bee.hoshaapp.base.ActivityFragmentAnnoation
import com.george.beetoturials.R
import com.george.beetoturials.base.fragments.BaseFragment
import com.george.beetoturials.databinding.FragmentLoginBinding
import com.george.beetoturials.models.auth.login.LoginBody
import com.george.beetoturials.ui.MainActivity
import com.george.beetoturials.ui.auth.AuthActivity
import com.george.beetoturials.utiles.EditTextHelper.getTxt
import com.george.beetoturials.utiles.EditTextHelper.isEmpty
import com.george.beetoturials.utiles.EditTextHelper.isFromValid
import com.george.beetoturials.utiles.EditTextModel
import com.george.beetoturials.utiles.EmailValidator.Companion.isEmailValid

@SuppressLint("NonConstantResourceId")
@ActivityFragmentAnnoation(R.layout.fragment_login)
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override val TAG: String get() = this.javaClass.name
    private val authViewModel = (activity as AuthActivity).authViewModel

    override fun initViewModel() {
        binding!!.apply {

        }
    }

    override fun setListener() {
        binding!!.apply {
            btnSignIn.setOnClickListener {
                val body = LoginBody(
                    email = etPhoneOrEmail.getTxt(),
                    pass = etPassword.getTxt(),
                    fcmid = "any"
                )
                if (formValidation()) {
                    lifecycleScope.launchWhenCreated {
                        authViewModel.login(body).observe(viewLifecycleOwner) { res ->
                            res.handler(
                                {showProgressDialog()},
                                {dismissProgressDialog()},
                                {dismissProgressDialog()}
                            ) {
                                dismissProgressDialog()
                                val intent = Intent(requireActivity(),MainActivity::class.java)
                                requireActivity().startActivity(intent)
                                requireActivity().finish()
                            }
                        }
                    }
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////// INPUTS VALIDATION ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private fun FragmentLoginBinding.formValidation(): Boolean {

        //****** Fill all required fields  *********//

        if (etPhoneOrEmail.isEmpty() && etPassword.isEmpty()) {
            showErrorSnackBar(root.rootView, "Fill all required fields ", true)
            return false
        }

        val model = listOf(
            EditTextModel(
                etPhoneOrEmail,
                "Please enter your email",
                "please enter a valid email",
            ) { isEmailValid(it.getTxt()) },
            EditTextModel(
                etPassword,
                "Please enter your password",
                "password not valid"
            ) {
                val str = it.getTxt()
                val regex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).+$")
                str.matches(regex) && str.length >= 8
            },
        )

        val errorMessages = isFromValid(model)

        if (errorMessages.isNotEmpty()) {
            showAuthErrorSnackBar(root, errorMessages)
            return false
        }

        return true
    }

}