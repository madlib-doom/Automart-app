package com.example.automartengines

import android.os.Bundle
import android.widget.ProgressBar
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
        //        find the progress bar and recyclerview by use of their ids

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView=findViewById<RecyclerView>(R.id.recycleView)

//        Define url where you are fetching
        val url="https://aarondev.pythonanywhere.com/api/getproducts"

//        import Helper
        val helper= ApiHelper(applicationContext)

//        we have a function called loadproducts which requires three parameteres
        helper.loadProducts(url,recyclerView,progressbar)
    }
}