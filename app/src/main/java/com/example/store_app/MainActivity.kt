package com.example.store_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.store_app.adapter.SliderAdapter
import com.example.store_app.data_class.ImageSlider
import com.example.store_app.fragment.AccountFragment
import com.example.store_app.fragment.CartFragment
import com.example.store_app.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // variabel buat bottom navigasi
    private lateinit var bottomNavigationView: BottomNavigationView

    // variabel buat objek fragment home, cart dan account
    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentCart: Fragment = CartFragment()
    private val fragmentAccount: Fragment = AccountFragment()

    // variabel buat fragment manager
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationBar()
    }

    private fun bottomNavigationBar() {

        // menampilkan halaman home saat pertama kali aplikasi dibuka
        fragmentManager.beginTransaction().replace(R.id.id_frame_layout, fragmentHome).commit()
        bottomNavigationView = findViewById(R.id.id_bottom_navbar)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.id_home_menu -> {
                    fragmentManager.beginTransaction().replace(R.id.id_frame_layout, fragmentHome).commit()
                    true
                }
                R.id.id_cart_menu -> {
                    fragmentManager.beginTransaction().replace(R.id.id_frame_layout, fragmentCart).commit()
                    true
                }
                R.id.id_account_menu -> {
                    fragmentManager.beginTransaction().replace(R.id.id_frame_layout, fragmentAccount).commit()
                    true
                }
                else -> false
            }
        }
    }
}