package com.ilkeruzer.marvel.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ilkeruzer.marvel.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    private val TRANSIT_TIME = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.animation)

        marvelImage.animation = animation

        val r = Runnable {
            goToMain()
        }
        Handler().postDelayed(r, TRANSIT_TIME.toLong())
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
}
