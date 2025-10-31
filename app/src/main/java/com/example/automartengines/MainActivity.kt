package com.example.automartengines

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle system bars padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buttons
        findViewById<Button>(R.id.signin).setOnClickListener {
            startActivity(Intent(applicationContext, SigninActivity::class.java))
        }

        findViewById<Button>(R.id.Signup).setOnClickListener {
            startActivity(Intent(applicationContext, SignupActivity::class.java))
        }

        findViewById<Button>(R.id.abut).setOnClickListener {
            startActivity(Intent(applicationContext, About::class.java))
        }

        // Quick Link Cards (Toast only)
        val quickCards = listOf(
            R.id.card_engine,
            R.id.card_oilfilter,
            R.id.card_battery,
            R.id.card_sparkplug
        )

        quickCards.forEach { id ->
            findViewById<CardView>(id).setOnClickListener {
                Toast.makeText(this, "Please log in to continue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
