package com.example.androidfinalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.androidfinalproject.R
import com.example.androidfinalproject.ScheduleViewModel
import com.example.androidfinalproject.databinding.FragmentActivitiesBinding
import com.example.androidfinalproject.databinding.FragmentCheckListBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
class CheckListFragment : Fragment() {
    private var _binding: FragmentCheckListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ScheduleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckListBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.returnToHome.setOnClickListener {
            val action = CheckListFragmentDirections.actionCheckListFragmentToMainFragment()
            rootView.findNavController().navigate(action)
        }

        binding.clearButton.setOnClickListener {


            val title = "Are You Sure You Would Like To Clear The List?"
            val message = "Please Click 'Yes' To Confirm Or 'No' To Keep Your Information Saved"
            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes") { dialog, which ->
                    binding.editTextText1.editableText.clear()
                    binding.editTextText2.editableText.clear()
                    binding.editTextText3.editableText.clear()
                    binding.editTextText4.editableText.clear()
                    binding.editTextText5.editableText.clear()
                    binding.editTextText6.editableText.clear()
                    binding.editTextText7.editableText.clear()
                    binding.editTextText8.editableText.clear()
                    binding.editTextText9.editableText.clear()
                    binding.editTextText10.editableText.clear()

                    binding.checkBox1.isChecked = false
                    binding.checkBox2.isChecked = false
                    binding.checkBox3.isChecked = false
                    binding.checkBox4.isChecked = false
                    binding.checkBox5.isChecked = false
                    binding.checkBox6.isChecked = false
                    binding.checkBox7.isChecked = false
                    binding.checkBox8.isChecked = false
                    binding.checkBox9.isChecked = false
                    binding.checkBox10.isChecked = false
                }
                .setNegativeButton("No") { dialog, which ->

                }
                .show()
        }
        return rootView

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}