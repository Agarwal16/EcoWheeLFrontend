package com.example.ecowheelfrontend

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen)

        val button = findViewById<TextView>(R.id.button)

        button.setOnClickListener{
//            button.setBackgroundColor(getColor(R.color.white))
//                button.setTextColor(getColor(R.color.green))
                    val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        }
    }