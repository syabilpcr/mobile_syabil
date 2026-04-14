package com.example.syabil_grape.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityDashboardBinding
import com.example.syabil_grape.pertemuan3.LoginActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "DashboardActivity dibuat pertama kali")

        // Terima judul dan deskripsi dari halaman sebelumnya
        val pageTitle = intent.getStringExtra("page_title") ?: "Dashboard"
        val pageDesc  = intent.getStringExtra("page_desc")  ?: "Pilih menu di bawah untuk melanjutkan"

        binding.tvDashboardTitle.text = pageTitle
        binding.tvDashboardDesc.text  = pageDesc

        // Tombol 1 - Bangun Ruang
        binding.btnBangunRuang.setOnClickListener {
            val intent = Intent(this, BangunRuangActivity::class.java)
            intent.putExtra("page_title", "Bangun Ruang")
            intent.putExtra("page_desc", "Hitung luas dan volume bangun ruang")
            startActivity(intent)
        }

        // Tombol 2 - Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("page_title", "Custom 1")
            intent.putExtra("page_desc", "Halaman kustom dengan gambar dan teks")
            startActivity(intent)
        }

        // Tombol 3 - Custom 2
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("page_title", "Custom 2")
            intent.putExtra("page_desc", "Halaman kustom kedua dengan konten berbeda")
            startActivity(intent)
        }

        // Tombol 4 - Logout dengan konfirmasi AlertDialog
        binding.btnLogout.setOnClickListener {
            showLogoutConfirmation()
        }
    }

    private fun showLogoutConfirmation() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin logout?")
            .setPositiveButton("Ya") { dialog, _ ->
                dialog.dismiss()
                Log.e("Logout", "Pengguna memilih logout")
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Log.e("Logout", "Logout dibatalkan")
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: DashboardActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "DashboardActivity dihapus dari stack")
    }
}