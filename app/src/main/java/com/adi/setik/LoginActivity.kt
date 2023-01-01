package com.adi.setik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val btnLogin = findViewById<Button>(R.id.btn_loginn)
        btnLogin.setOnClickListener {
            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
        }
    }
}