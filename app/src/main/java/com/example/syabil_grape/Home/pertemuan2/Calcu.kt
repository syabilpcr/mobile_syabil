package com.example.syabil_grape.Home.pertemuan2

class Calcu {

    fun tambah(a: Double, b: Double): Double {
        return a + b
    }

    fun kurang(a: Double, b: Double): Double {
        return a - b
    }

    fun kali(a: Double, b: Double): Double {
        return a * b
    }

    fun bagi(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException("Tidak bisa dibagi dengan nol")
        return a / b
    }

    fun hitungLuasLingkaran(r: Double): Double {
        return Math.PI * r * r
    }

    fun hitungKelilingLingkaran(r: Double): Double {
        return 2 * Math.PI * r
    }
}