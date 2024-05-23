package com.example.androidfinalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.androidfinalproject.R
import com.example.androidfinalproject.ScheduleViewModel
import com.example.androidfinalproject.adapters.ActivitiesAdapter
import com.example.androidfinalproject.adapters.ClassesAdapter
import com.example.androidfinalproject.databinding.FragmentMainBinding
import com.example.androidfinalproject.databinding.FragmentSchoolBinding
import com.example.androidfinalproject.dataclasses.Activity
import com.example.androidfinalproject.dataclasses.SchoolClass

class SchoolFragment : Fragment() {
    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ScheduleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)
        val rootView = binding.root


        val myAdapter = ClassesAdapter(viewModel.classList)
        binding.schoolRecyclerView.adapter = myAdapter

        binding.returnHome.setOnClickListener {
            val action = SchoolFragmentDirections.actionSchoolFragmentToMainFragment()
            rootView.findNavController().navigate(action)
        }

        binding.button.setOnClickListener {
            val action = SchoolFragmentDirections.actionSchoolFragmentToAddClassFragment()
            rootView.findNavController().navigate(action)
        }

        setFragmentResultListener("REQUESTING_REPLY_KEY"){requestKey: String, bundle: Bundle ->
            val className = bundle.getString("CLASS_KEY").toString()
            val teacherName = bundle.getString("TEACH_KEY").toString()
            val period = bundle.getString("PERIOD_KEY").toString()
            val difficulty = bundle.getString("DIFF_KEY").toString()
            viewModel.addNewClass(className, teacherName, period.toInt(), difficulty.toInt())
        }


        return rootView
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}