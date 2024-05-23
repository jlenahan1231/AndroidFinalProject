package com.example.androidfinalproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.androidfinalproject.MainFragmentDirections
import com.example.androidfinalproject.R
import com.example.androidfinalproject.ScheduleViewModel
import com.example.androidfinalproject.adapters.ActivitiesAdapter
import com.example.androidfinalproject.databinding.FragmentActivitiesBinding
import com.example.androidfinalproject.databinding.FragmentMainBinding
import com.example.androidfinalproject.dataclasses.Activity

class ActivitiesFragment : Fragment() {
    private var _binding: FragmentActivitiesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ScheduleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        val rootView = binding.root


        val myAdapter = ActivitiesAdapter(viewModel.activityList)
        binding.activitiesRecyclerView.adapter = myAdapter

        binding.returnHome.setOnClickListener {
            val action = ActivitiesFragmentDirections.actionActivitiesFragmentToMainFragment()
            rootView.findNavController().navigate(action)
        }

        binding.button.setOnClickListener {
            val action = ActivitiesFragmentDirections.actionActivitiesFragmentToAddActivityFragment()
            rootView.findNavController().navigate(action)
        }


        setFragmentResultListener("REQUESTING_REPLY_KEY"){requestKey: String, bundle: Bundle ->
            val activityName = bundle.getString("ACTIVITY_KEY").toString()
            val timesPerWeek = bundle.getString("WEEK_KEY").toString()
            val address = bundle.getString("ADDRESS_KEY").toString()
            viewModel.addActivity(activityName, timesPerWeek.toInt(), address)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}