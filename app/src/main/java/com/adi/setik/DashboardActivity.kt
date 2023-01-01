package com.adi.setik

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.RelativeLayout
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.adi.setik.adapter.WisataCarouselAdapter
import com.adi.setik.model.WisataCarouselModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val appBarLayout = findViewById<AppBarLayout>(R.id.appbar_layout)
        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar_layout)
        var isShow = true
        var scrollRange = -1
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1){
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0){
                collapsingToolbarLayout.title = "TripKu App"
                isShow = true
            } else if (isShow){
                collapsingToolbarLayout.title = " "
                isShow = false
            }
        })

        var wisataList = ArrayList<WisataCarouselModel>()
        wisataList.add(WisataCarouselModel("Candi Prambanan", "Yogyakarta", R.drawable.contoh1))
        wisataList.add(WisataCarouselModel("Taman Sari", "Yogyakarta", R.drawable.contoh2))
        wisataList.add(WisataCarouselModel("Dusun Semilir", "Kab.Semarang", R.drawable.contoh_3))

        val wisataCarousel = findViewById<ViewPager2>(R.id.view_pager_carousel_wisata)
        wisataCarousel.apply {
            adapter = WisataCarouselAdapter(wisataList)
            offscreenPageLimit = 1
            setPageTransformer(MarginPageTransformer(1))
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }

        val paketWisata1 = findViewById<CardView>(R.id.paket_wisata1)

        paketWisata1.setOnClickListener {
            startActivity(Intent(this, DetailPaketWisataActivity::class.java))
        }



    }
}