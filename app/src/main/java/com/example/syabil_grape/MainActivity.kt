package com.example.syabil_grape

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//

class MainActivity : AppCompatActivity() {


    var rumusDipilih = "persegi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val in1 = findViewById<EditText>(R.id.input_1)
        val in2 = findViewById<EditText>(R.id.input_2)
        val btnPersegi = findViewById<Button>(R.id.tombol_persegi_panjang)
        val btnTabung = findViewById<Button>(R.id.tombol_tabung)
        val btnHitung = findViewById<Button>(R.id.tombol_hitung)
        val txtHasil = findViewById<TextView>(R.id.teks_hasil)


        btnPersegi.setOnClickListener {
            rumusDipilih = "persegi"
            in1.hint = "Isi Panjang"
            in2.hint = "Isi Lebar"
            in1.text.clear()
            in2.text.clear()
            txtHasil.text = "Hasil: 0"
        }


        btnTabung.setOnClickListener {
            rumusDipilih = "tabung"
            in1.hint = "Isi Jari-jari"
            in2.hint = "Isi Tinggi"
            in1.text.clear()
            in2.text.clear()
            txtHasil.text = "Hasil: 0"
        }


        btnHitung.setOnClickListener {
            val angka1 = in1.text.toString().toDoubleOrNull() ?: 0.0
            val angka2 = in2.text.toString().toDoubleOrNull() ?: 0.0

            if (rumusDipilih == "persegi") {
                // Rumus Luas: p * l
                val luas = angka1 * angka2
                txtHasil.text = "Luas: $luas"
            } else {
                // Rumus Volume Tabung: 3.14 * r * r * t
                val volume = 3.14 * angka1 * angka1 * angka2
                txtHasil.text = "Volume: $volume"
            }
        }
    }
}