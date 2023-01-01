package com.adi.setik

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.adi.setik.adapter.ViewPagerAdapter
import com.adi.setik.fragments.DeskripsiWisata
import com.adi.setik.fragments.TujuanWisata
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class DetailPaketWisataActivity : AppCompatActivity() {
    private val images = arrayListOf(R.drawable.contoh1,
        R.drawable.contoh2, R.drawable.contoh_3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_paket_wisata)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Paket Wisata"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tablayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewpager = findViewById<ViewPager2>(R.id.view_pager)
//        val btnPesan = findViewById<Button>(R.id.btn_pesann)

        val bun = Bundle()
        bun.putString("namaPaket", "Paket Wisata Bromo")
        val fragments = ArrayList<Fragment>()
        fragments.add(DeskripsiWisata())
        fragments.add(TujuanWisata())

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragments)

        viewpager.adapter = adapter
        TabLayoutMediator(tablayout, viewpager){tab, position ->
            when(position) {
                0 -> tab.text = "Deskripsi"
                1 -> tab.text = "Tujuan Wisata"
            }
        }.attach()


//        btnPesan.setOnClickListener {
//            startActivity(Intent(this, PesanActivity::class.java))
//        }



    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }



}