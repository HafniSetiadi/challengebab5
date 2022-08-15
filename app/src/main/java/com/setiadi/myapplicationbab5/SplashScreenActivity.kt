package com.setiadi.myapplicationbab5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.setiadi.myapplicationbab5.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private var layout: ActivitySplashScreenBinding? = null
    lateinit var handler: Handler
    private val image = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val layout = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(layout.root)

        val imageGlide = findViewById<ImageView>(R.id.ivGlide)

        Glide.with(this)
            .load(image)
            .into(imageGlide)


        handler = Handler()
        handler.postDelayed(
            {
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )
    }
}
