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
import com.example.androidfinalproject.databinding.FragmentAddClassBinding

class AddClassFragment : Fragment() {
    private var _binding: FragmentAddClassBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddClassBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.confirmClass.setOnClickListener {
            val className = binding.enterClassName.editableText.toString()
            val teacherName = binding.enterTeacherName.editableText.toString()
            val period = binding.enterClassPeriod.editableText.toString()
            val difficulty = binding.enterClassDiff.editableText.toString()
            setFragmentResult("REQUESTING_REPLY_KEY", bundleOf("CLASS_KEY" to className, "TEACH_KEY" to teacherName,
                "PERIOD_KEY" to period, "DIFF_KEY" to difficulty)
            )
            rootView.findNavController().navigateUp()
        }

        binding.backButton.setOnClickListener { rootView.findNavController().navigateUp() }

        return rootView
    }
}