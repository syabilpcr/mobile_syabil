package com.example.syabil_grape.Home.pertemuan4

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityBangunRuangBinding
import kotlin.math.PI

class BangunRuangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBangunRuangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBangunRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "BangunRuangActivity dibuat pertama kali")

        // Tampilkan judul dan deskripsi dari intent
        val pageTitle = intent.getStringExtra("page_title") ?: "Bangun Ruang"
        val pageDesc  = intent.getStringExtra("page_desc")  ?: "Hitung luas dan volume bangun ruang"
        binding.tvPageTitle.text = pageTitle
        binding.tvPageDesc.text  = pageDesc

        // Back button
        binding.ivBack.setOnClickListener {
            finish()
        }

        // Hitung Kubus
        binding.btnHitungKubus.setOnClickListener {
            val sisiStr = binding.etSisiKubus.text.toString()
            if (sisiStr.isEmpty()) {
                Toast.makeText(this, "Masukkan panjang sisi kubus!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val sisi = sisiStr.toDoubleOrNull() ?: run {
                Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val volume  = sisi * sisi * sisi
            val luasPerm = 6 * sisi * sisi
            binding.tvHasilKubus.text = "Volume : ${String.format("%.2f", volume)} cm³\n" +
                    "Luas Permukaan : ${String.format("%.2f", luasPerm)} cm²"
            Log.e("BangunRuang", "Kubus sisi=$sisi | V=$volume | LP=$luasPerm")
        }

        // Hitung Balok
        binding.btnHitungBalok.setOnClickListener {
            val p = binding.etPanjangBalok.text.toString().toDoubleOrNull()
            val l = binding.etLebarBalok.text.toString().toDoubleOrNull()
            val t = binding.etTinggiBalok.text.toString().toDoubleOrNull()

            if (p == null || l == null || t == null) {
                Toast.makeText(this, "Lengkapi semua input balok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val volume  = p * l * t
            val luasPerm = 2 * ((p * l) + (p * t) + (l * t))
            binding.tvHasilBalok.text = "Volume : ${String.format("%.2f", volume)} cm³\n" +
                    "Luas Permukaan : ${String.format("%.2f", luasPerm)} cm²"
            Log.e("BangunRuang", "Balok p=$p l=$l t=$t | V=$volume | LP=$luasPerm")
        }

        // Hitung Bola
        binding.btnHitungBola.setOnClickListener {
            val r = binding.etJariJariBola.text.toString().toDoubleOrNull()
            if (r == null) {
                Toast.makeText(this, "Masukkan jari-jari bola!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val volume  = (4.0 / 3.0) * PI * r * r * r
            val luasPerm = 4 * PI * r * r
            binding.tvHasilBola.text = "Volume : ${String.format("%.2f", volume)} cm³\n" +
                    "Luas Permukaan : ${String.format("%.2f", luasPerm)} cm²"
            Log.e("BangunRuang", "Bola r=$r | V=$volume | LP=$luasPerm")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: BangunRuangActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "BangunRuangActivity dihapus dari stack")
    }
}