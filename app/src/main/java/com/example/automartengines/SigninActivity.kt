package com.example.automartengines

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Find views
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val signButton = findViewById<Button>(R.id.signin)
        val signupText = findViewById<TextView>(R.id.tv_signup) // clickable "Sign up" text

        // 🔹 Handle sign-in button click
        signButton.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            // ✅ Validate input before API call
            if (emailText.isEmpty()) {
                email.error = "Email is required"
                email.requestFocus()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.error = "Enter a valid email"
                email.requestFocus()
                return@setOnClickListener
            }

            if (passwordText.isEmpty()) {
                password.error = "Password is required"
                password.requestFocus()
                return@setOnClickListener
            }

            // ✅ If validation passes, call API
            val api = "https://aarondev.pythonanywhere.com/api/signin"
            val data = RequestParams().apply {
                put("email", emailText)
                put("password", passwordText)
            }

            val helper = ApiHelper(applicationContext)
            helper.post_login(api, data)

            Toast.makeText(this, "Signing in...", Toast.LENGTH_SHORT).show()
        }

        // 🔹 Navigate to Sign Up screen when text clicked
        signupText.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish() // optional, to prevent back navigation
        }
    }
}
