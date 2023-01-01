package com.adi.setik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adi.setik.R
import com.adi.setik.model.WisataCarouselModel

class WisataCarouselAdapter(private val carouselDataList: ArrayList<WisataCarouselModel>) :
    RecyclerView.Adapter<WisataCarouselAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_wisata_home, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val textViewNama = holder.itemView.findViewById<TextView>(R.id.nama_wisata)
        val textViewLokasi = holder.itemView.findViewById<TextView>(R.id.lokasi_wisata)
        val imageWisata = holder.itemView.findViewById<ImageView>(R.id.gambar_wisata)
        textViewNama.text = carouselDataList[position].nama
        textViewLokasi.text = carouselDataList[position].lokasi
        imageWisata.setImageResource(carouselDataList[position].gambar)
    }

    override fun getItemCount(): Int {
        return carouselDataList.size
    }

}