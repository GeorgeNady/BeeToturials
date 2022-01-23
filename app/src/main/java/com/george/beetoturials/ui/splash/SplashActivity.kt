package com.george.beetoturials.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.george.beetoturials.R
import com.george.beetoturials.ui.auth.AuthActivity
import com.george.beetoturials.utiles.Preferences.Companion.prefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        CoroutineScope(Dispatchers.Main).launch {

            delay(3000)

            if (prefs.prefsToken == "") {

                startActivity(Intent(this@SplashActivity,AuthActivity::class.java))

            } else {

                // startActivity(Intent(this,MainActivity::class.java))

            }

        }

    }

}