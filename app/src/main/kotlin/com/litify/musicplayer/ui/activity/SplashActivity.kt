package com.litify.musicplayer.ui.activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.litify.musicplayer.R
import com.litify.musicplayer.databinding.ActivitySplashBinding
import android.content.Intent

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)
        binding.splashLogo.startAnimation(scaleAnimation)

        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_animation)
        binding.splashText.startAnimation(fadeAnimation)

        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, 2000)
    }
}