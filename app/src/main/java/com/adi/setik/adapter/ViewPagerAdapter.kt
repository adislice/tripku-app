package com.adi.setik.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adi.setik.fragments.DeskripsiWisata
import com.adi.setik.fragments.TujuanWisata

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, fragments: ArrayList<Fragment>):
        FragmentStateAdapter(fragmentManager, lifecycle) {
    var fragments = fragments

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]

    }

}