package com.example.happygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val action = supportActionBar
        action?.hide()
        try {
            Handler().postDelayed(
                {
                    startActivity(
                        Intent(
                            this@welcome,
                            play::class.java
                        )
                    )
                }, 3000
            )
        }
        catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }
}