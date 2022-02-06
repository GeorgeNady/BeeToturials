package com.george.beetoturials.base.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.george.beetoturials.R
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment<T : ViewDataBinding?> : Fragment() {

    abstract val TAG: String

    private var contentId = 0
    var bundle: Bundle? = null
    var a: Activity? = null
    var binding: T? = null
    var progressDialog: ProgressDialog? = null

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (contentId == 0) {
            bundle = arguments
            contentId = ActivityFragmentAnnoationManager.check(this)
            a = activity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, contentId, container, false)
        }
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setListener()
    }

    protected abstract fun initViewModel()
    protected abstract fun setListener()

    /////////////////////////////////////////////////////////////////////////////////////// KEYBOARD
    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    ////////////////////////////////////////////////////////////////////////////////////// SNACK_BAR
    @SuppressLint("ShowToast")
    fun showErrorSnackBar(view: View, message: String, isError: Boolean) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT).apply {
            // mainActivity?.let { anchorView = it.binding.bnv }
            setBackgroundTint(
                if (isError) ContextCompat.getColor(
                    requireContext(),
                    R.color.danger
                ) else ContextCompat.getColor(
                    requireContext(), R.color.success
                )
            )
        }
        snackBar.show()
    }

    fun showAuthErrorSnackBar(view: View, message: String) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).apply {
            setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.danger))
            setActionTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            setAction("Got it") { dismiss() }
        }
        snackBar.show()
    }

    fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    fun showSnackBar(context: Context, view: View, message: String) {
        Snackbar.make(context, view, message, Snackbar.LENGTH_LONG).show()
    }

    //////////////////////////////////////////////////////////////////////////////// PROGRESS DIALOG
    fun showProgressDialog() {
        try {
            if (progressDialog != null && progressDialog!!.isShowing) dismissProgressDialog()
            progressDialog = ProgressDialog(requireContext())
            progressDialog!!.setMessage(getString(R.string.please_wait))
            progressDialog!!.window!!.setBackgroundDrawable(
                ColorDrawable(Color.WHITE)
            )
            progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog!!.show()
            progressDialog!!.setCanceledOnTouchOutside(false)
        } catch (e: Exception) {
        }
    }

    fun dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

}