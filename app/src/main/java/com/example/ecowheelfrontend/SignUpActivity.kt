package com.example.ecowheelfrontend

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
//            signUpButton.setTextColor(getColor(R.color.green)) // Example color change
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Populate Spinner
        val batchSpinner: Spinner = findViewById(R.id.batchSpinner)
        val batches = arrayOf("2k22", "2k23")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, batches)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        batchSpinner.adapter = adapter

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
