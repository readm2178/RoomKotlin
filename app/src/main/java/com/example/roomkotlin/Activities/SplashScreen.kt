package com.example.roomkotlin.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.roomkotlin.R
import com.example.roomkotlin.ui.main.view.MainActivity2


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_SCREEN_TIME_OUT = 3000
    }
}

