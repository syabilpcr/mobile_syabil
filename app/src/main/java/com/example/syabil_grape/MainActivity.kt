package com.example.syabil_grape

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.syabil_grape.pertemuan2.CalcuActivity
import com.example.syabil_grape.pertemuan3.LoginActivity
import com.example.syabil_grape.pertemuan4.DashboardActivity
import com.example.syabil_grape.pertemuan5.FifthActivity
import com.example.syabil_grape.pertemuan5.WebViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "PT. BESMINDO"

        // SharedPreferences
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        // Tampilkan username
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        tvUsername.text = username

        // Navigasi
        val btnPertemuan2 = findViewById<LinearLayout>(R.id.btnPertemuan2)
        val btnPertemuan4 = findViewById<LinearLayout>(R.id.btnPertemuan4)
        val btnPertemuan5 = findViewById<LinearLayout>(R.id.btnPertemuan5)
        val btnWebsite = findViewById<LinearLayout>(R.id.btnWebsite)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnPertemuan2.setOnClickListener {
            startActivity(Intent(this, CalcuActivity::class.java))
        }

        btnPertemuan4.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        btnPertemuan5.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }

        btnWebsite.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", "http://syabil-sic.alwaysdata.net/")
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah kamu yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit().clear().apply()
                    dialog.dismiss()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}