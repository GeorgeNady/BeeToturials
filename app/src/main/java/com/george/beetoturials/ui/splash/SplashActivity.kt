package com.george.beetoturials.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.george.beetoturials.R
import com.george.beetoturials.base.BaseActivity
import com.george.beetoturials.databinding.ActivitySplashBinding
import com.george.beetoturials.ui.auth.AuthActivity
import com.george.beetoturials.utiles.Preferences.Companion.prefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>(
    ActivitySplashBinding::inflate
) {

    override val TAG: String get() = this.javaClass.name

    override fun beforeCreatingView() {
        setTheme(R.style.Theme_Hosha)
    }

    override fun initialization() {}

    override fun setListener() {
        CoroutineScope(Dispatchers.Main).launch {
            if (prefs.prefsToken == "") {
                startActivity(Intent(this@SplashActivity,AuthActivity::class.java))
            } else {
                // startActivity(Intent(this,MainActivity::class.java))
            }

        }
    }

}