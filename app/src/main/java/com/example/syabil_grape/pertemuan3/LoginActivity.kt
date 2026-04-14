package com.example.syabil_grape.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.syabil_grape.databinding.ActivityLoginBinding
import com.example.syabil_grape.pertemuan4.DashboardActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val validUsername = "admin"
    private val validPassword = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "LoginActivity dibuat pertama kali")

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.tilUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilUsername.error = null
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            if (username == validUsername && password == validPassword) {
                Log.e("Login", "Login berhasil! Username: $username")
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("page_title", "Dashboard")
                intent.putExtra("page_desc", "Selamat datang, $username!")
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
                Log.e("Login", "Login gagal! Username: $username")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: LoginActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "LoginActivity dihapus dari stack")
    }
}