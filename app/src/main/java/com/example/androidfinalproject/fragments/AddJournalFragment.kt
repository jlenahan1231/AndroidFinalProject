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
import com.example.androidfinalproject.databinding.FragmentAddJournalBinding

class AddJournalFragment : Fragment() {
    private var _binding: FragmentAddJournalBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddJournalBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.confirmJournal.setOnClickListener {
            val entryTitle = binding.enterEntryTitle.editableText.toString()
            val entryText = binding.enterEntryText.editableText.toString()
            val dateOfEntry = binding.journalDate.editableText.toString()
            setFragmentResult("REQUESTING_REPLY_KEY", bundleOf("ENTRY_KEY" to entryTitle, "TEXT_KEY" to entryText,
                "DATE_KEY" to dateOfEntry)
            )
            rootView.findNavController().navigateUp()
        }

        binding.back.setOnClickListener { rootView.findNavController().navigateUp() }


        return rootView
    }
}