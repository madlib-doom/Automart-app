package com.example.automartengines

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //        find the textview by use of id
        val text=findViewById<TextView>(R.id.tvUsername)

        //get username restored from api
        val prefs=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val username=prefs.getString("username","user")

//        Bind to textview
        text.text="Welcome, $username"

        //        find the progress bar and recyclerview by use of their ids

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView=findViewById<RecyclerView>(R.id.recycleView)

//        Define url where you are fetching
        val url="https://rexkinoo.pythonanywhere.com/api/getproducts"

//        import Helper
        val helper= ApiHelper(applicationContext)

//        we have a function called loadproducts which requires three parameteres
        helper.loadProducts(url,recyclerView,progressbar)
//        findbutton by use of id
        val buttonsell=findViewById<Button>(R.id.btnSell)

        buttonsell.setOnClickListener {
            val selpage= Intent(applicationContext, Addproducts::class.java)
            startActivity(selpage)
        }//end listener
//        find logout button and by use of its id
        val logout=findViewById<Button>(R.id.btnLogout
        )
        logout.setOnClickListener {
//            clear shared preferences
            val prefs=getSharedPreferences("user_session", Context.MODE_PRIVATE)
            prefs.edit().clear().apply()

//            navigate to mainactivity
            val firstpage= Intent(applicationContext, MainActivity::class.java)
            startActivity(firstpage)

        }

    }
}