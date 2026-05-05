package com.example.syabil_grape.Home.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "WelcomeActivity dibuat pertama kali")

        // Ambil data dari intent
        val username = intent.getStringExtra("username") ?: "Pengguna"

        binding.tvUsername.text = username
        binding.tvInfoUsername.text = "Login sebagai: $username"

        binding.btnLogout.setOnClickListener {
            Log.e("Logout", "Pengguna $username logout")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: WelcomeActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "WelcomeActivity dihapus dari stack")
    }
}