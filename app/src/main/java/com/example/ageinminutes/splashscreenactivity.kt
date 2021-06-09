package com.example.ageinminutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_splashscreenactivity.*

class splashscreenactivity : AppCompatActivity() {
    val splash_time_out:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreenactivity)

        val lottieanimation=findViewById<LottieAnimationView>(R.id.lottie)

        lottieanimation.animate().translationY(1400f).setDuration(1000).setStartDelay(4000)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },splash_time_out)







    }
}


