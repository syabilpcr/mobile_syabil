package com.example.syabil_grape

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityBaseBinding
import com.example.syabil_grape.Home.HomeFragment
import com.example.syabil_grape.About.AboutFragment
import com.example.syabil_grape.Profile.ProfileFragment
import androidx.fragment.app.Fragment

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fix bottom padding agar BottomNav tidak punya jarak di bawah
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Tampilkan HomeFragment sebagai fragment default
        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.about -> {
                    replaceFragment(AboutFragment())
                    true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            // addToBackStack dinonaktifkan agar tombol back langsung keluar aplikasi
            .commit()
    }
}