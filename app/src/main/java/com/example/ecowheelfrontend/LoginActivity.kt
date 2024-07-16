package com.example.ecowheelfrontend

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<TextView>(R.id.sign)
        button.setOnClickListener {
//            button.setTextColor(getColor(R.color.green))
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)


            // Toggle Password Visibility
            val passwordEditText: EditText = findViewById(R.id.password)
            val togglePasswordVisibility: ImageView = findViewById(R.id.password_eye_button)

            togglePasswordVisibility.setOnClickListener {
                if (passwordEditText.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    passwordEditText.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    togglePasswordVisibility.setImageResource(R.drawable.ic_eye_off)
                } else {
                    passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    togglePasswordVisibility.setImageResource(R.drawable.ic_eye_on)
                }
                passwordEditText.setSelection(passwordEditText.text.length) // Move cursor to end
            }
        }
    }
}
