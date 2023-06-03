package com.example.store_app.fragment

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.store_app.R
import com.example.store_app.adapter.SliderAdapter
import com.example.store_app.data_class.ImageSlider
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2;
    private lateinit var imageList: ArrayList<ImageSlider>;
    private lateinit var rootView: View;

    // buat auto slider
    private lateinit var timer: Timer;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        imageSlider()
        return rootView
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
    }

    override fun onResume() {
        super.onResume()
        startAutoImageSlider()
    }

    private fun imageSlider() {

        imageList = arrayListOf(
            ImageSlider(R.drawable.smartphone_one),
            ImageSlider(R.drawable.smartphone_two),
            ImageSlider(R.drawable.smartphone_three),
            ImageSlider(R.drawable.smartphone_four),
            ImageSlider(R.drawable.smartphone_five)
        )

        viewPager = rootView.findViewById(R.id.id_viewpager2)
        val sliderAdapter = SliderAdapter(imageList);
        viewPager.adapter = sliderAdapter

        // panggil method startAutoImageSlider
        startAutoImageSlider()
    }

    private fun startAutoImageSlider() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                // Kode untuk menggeser tampilan gambar
                activity?.runOnUiThread {
                    viewPager.currentItem = (viewPager.currentItem + 1) % imageList.size
                }
            }
        }, 3000, 3000)
    }
}