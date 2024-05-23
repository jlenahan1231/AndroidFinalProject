package com.example.androidfinalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.androidfinalproject.MainFragmentDirections
import com.example.androidfinalproject.R
import com.example.androidfinalproject.databinding.FragmentAboutBinding
import com.example.androidfinalproject.databinding.FragmentMainBinding

class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.homeButton.setOnClickListener {
            val action = AboutFragmentDirections.actionAboutFragmentToMainFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}