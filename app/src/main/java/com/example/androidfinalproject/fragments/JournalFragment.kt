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
import com.example.androidfinalproject.adapters.JournalAdapter
import com.example.androidfinalproject.databinding.FragmentJournalBinding
import com.example.androidfinalproject.databinding.FragmentMainBinding
import com.example.androidfinalproject.dataclasses.Activity
import com.example.androidfinalproject.dataclasses.Journal

class JournalFragment : Fragment() {
    private var _binding: FragmentJournalBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ScheduleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJournalBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val myAdapter = JournalAdapter(viewModel.entryList)
        binding.journalRecyclerView.adapter = myAdapter

        binding.returnHome.setOnClickListener {
            val action = JournalFragmentDirections.actionJournalFragmentToMainFragment()
            rootView.findNavController().navigate(action)
        }

        binding.button.setOnClickListener {
            val action = JournalFragmentDirections.actionJournalFragmentToAddJournalFragment()
            rootView.findNavController().navigate(action)
        }

        setFragmentResultListener("REQUESTING_REPLY_KEY"){requestKey: String, bundle: Bundle ->
            val entryTitle = bundle.getString("ENTRY_KEY").toString()
            val entryText = bundle.getString("TEXT_KEY").toString()
            val dateOfEntry = bundle.getString("DATE_KEY").toString()
            viewModel.addJournal(entryTitle, entryText, dateOfEntry)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}