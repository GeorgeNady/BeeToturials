package com.george.beetoturials.ui.auth.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import bee.bee.hoshaapp.base.ActivityFragmentAnnoation
import com.george.beetoturials.R
import com.george.beetoturials.base.fragments.BaseFragment
import com.george.beetoturials.databinding.FragmentRegisterBinding
import com.george.beetoturials.models.auth.register.RegisterBody
import com.george.beetoturials.ui.auth.AuthActivity
import com.george.beetoturials.utiles.EditTextHelper.getTxt
import java.util.*

@SuppressLint("NonConstantResourceId")
@ActivityFragmentAnnoation(R.layout.fragment_register)
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override val TAG: String get() = this.javaClass.name
    private val authViewModel = (activity as AuthActivity).authViewModel

    private lateinit var day: String
    private lateinit var month: String
    private lateinit var year: String
    private var gender = ""
    private var isTermsChecked = true

    override fun initViewModel() {
        binding!!.apply {

        }
    }

    override fun setListener() {
        binding!!.apply {
            btnSignUp.setOnClickListener {
                // create body
                /*val body = RegisterBody(
                    name = etFullName.getTxt(),
                    username = etUserName.getTxt(),
                    email = etPhoneOrEmail.getTxt(),
                    password = etPassword.getTxt(),
                    gender = "",
                    birthdate = "",
                    phone = "",
                    fcmId = ""
                )*/
                // validate inputs
                // call api
                // handle response
            }
            btnSignIn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun spinnerYearsGenerator(spinner: Spinner, context: Context) {

        val yearsList = arrayListOf<String>()
        val currentYear = Calendar.getInstance()[Calendar.YEAR]
        val count = 60
        yearsList.add("Year")
        for (i in 0 until count) {
            yearsList.add((currentYear - i).toString())
        }
        val yearsAdapter =
            ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, yearsList)
        spinner.adapter = yearsAdapter
    }

}