package com.example.automartengines

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signin_button=findViewById<Button>(R.id.signin)
        signin_button.setOnClickListener {
            val sign_intent= Intent(applicationContext, SigninActivity::class.java)
            startActivity(sign_intent)
        }
        val sognup_button=findViewById<Button>(R.id.Signup)
        sognup_button.setOnClickListener {
            val signup_intenet= Intent(applicationContext, SignupActivity::class.java)
            startActivity(signup_intenet)
        }   //endlistener



    }
}