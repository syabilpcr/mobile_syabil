package com.example.syabil_grape.Home.pertemuan4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityCustom1Binding

class Custom1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCustom1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustom1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "Custom1Activity dibuat pertama kali")

        // Tampilkan judul dan deskripsi dari intent (dikirim dari DashboardActivity)
        val pageTitle = intent.getStringExtra("page_title") ?: "Custom 1"
        val pageDesc  = intent.getStringExtra("page_desc")  ?: "Halaman kustom dengan gambar dan teks"

        binding.tvPageTitle.text = pageTitle
        binding.tvPageDesc.text  = pageDesc

        // Tombol back
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: Custom1Activity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "Custom1Activity dihapus dari stack")
    }
}