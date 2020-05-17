package com.smkcoding.smkcodingchalleng2.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.smkcoding.smkcodingchalleng2.MainActivity
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.login.Login

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)

        //4second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashScreen, Login::class.java))
            //finish this activity
            finish()
        },4000)

    }
}
