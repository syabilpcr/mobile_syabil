package com.example.syabil_grape.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.syabil_grape.Home.pertemuan2.CalcuActivity
import com.example.syabil_grape.Home.pertemuan3.LoginActivity
import com.example.syabil_grape.Home.pertemuan4.DashboardActivity
import com.example.syabil_grape.Home.pertemuan5.FifthActivity
import com.example.syabil_grape.Home.pertemuan6.AuthActivity
import com.example.syabil_grape.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // Tombol navigasi ke setiap pertemuan
        binding.btnPertemuan2.setOnClickListener {
            val intent = Intent(requireContext(), CalcuActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan3.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity
            ::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireContext(), DashboardActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnPertemuan6.setOnClickListener {
            val intent = Intent(requireContext(), AuthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}