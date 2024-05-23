package com.example.androidfinalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.androidfinalproject.R
import com.example.androidfinalproject.databinding.FragmentActivitiesBinding
import com.example.androidfinalproject.databinding.FragmentAddActivityBinding

class AddActivityFragment : Fragment() {
    private var _binding: FragmentAddActivityBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddActivityBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.confirmActivity.setOnClickListener {
            val activityName = binding.enterActivityName.editableText.toString()
            val timesPerWeek = binding.enterTimePerWeek.editableText.toString()
            val location = binding.enterAddress.editableText.toString()
            setFragmentResult("REQUESTING_REPLY_KEY", bundleOf("ACTIVITY_KEY" to activityName, "WEEK_KEY" to timesPerWeek,
                "ADDRESS_KEY" to location))
            rootView.findNavController().navigateUp()
        }

        binding.backButton2.setOnClickListener { rootView.findNavController().navigateUp() }

        return rootView
    }

}