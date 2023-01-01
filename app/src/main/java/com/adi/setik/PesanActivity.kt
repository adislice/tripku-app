package com.adi.setik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PesanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)
        supportActionBar?.title = "Pesan Paket Wisata"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}