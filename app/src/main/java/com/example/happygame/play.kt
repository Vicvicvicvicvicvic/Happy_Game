package com.example.happygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.material.button.MaterialButton

class play : AppCompatActivity() {
    private lateinit var playbtn:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val action = supportActionBar
        action?.hide()
        playbtn = findViewById(R.id.playbtn)
        playbtn.setOnClickListener {
            startActivity(Intent(this@play, MainActivity::class.java))
        }

    }
}