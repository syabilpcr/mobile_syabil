package com.example.syabil_grape.pertemuan2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityCalcuBinding

class CalcuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalcuBinding
    private val calcu = Calcu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "CalcuActivity dibuat pertama kali")

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnTambah.setOnClickListener {
            hitungOperasi("tambah")
        }

        binding.btnKurang.setOnClickListener {
            hitungOperasi("kurang")
        }

        binding.btnKali.setOnClickListener {
            hitungOperasi("kali")
        }

        binding.btnBagi.setOnClickListener {
            hitungOperasi("bagi")
        }
    }

    private fun hitungOperasi(operasi: String) {
        val input1 = binding.etAngka1.text.toString()
        val input2 = binding.etAngka2.text.toString()

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua angka terlebih dahulu!", Toast.LENGTH_SHORT).show()
            return
        }

        val angka1 = input1.toDoubleOrNull()
        val angka2 = input2.toDoubleOrNull()

        if (angka1 == null || angka2 == null) {
            Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val hasil = when (operasi) {
                "tambah" -> calcu.tambah(angka1, angka2)
                "kurang" -> calcu.kurang(angka1, angka2)
                "kali"   -> calcu.kali(angka1, angka2)
                "bagi"   -> calcu.bagi(angka1, angka2)
                else     -> 0.0
            }

            val hasilFormatted = if (hasil % 1 == 0.0) {
                hasil.toLong().toString()
            } else {
                String.format("%.4f", hasil)
            }

            binding.tvHasil.text = hasilFormatted
            Log.e("Kalkulasi", "Operasi: $operasi | $angka1 op $angka2 = $hasil")

        } catch (e: ArithmeticException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: CalcuActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "CalcuActivity dihapus dari stack")
    }
}