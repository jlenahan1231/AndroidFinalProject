package com.example.androidfinalproject.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.JournalItemLayoutBinding
import com.example.androidfinalproject.dataclasses.Journal

class JournalViewHolder(val binding: JournalItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentEntry: Journal

        fun bindEntry(entry: Journal){
            currentEntry = entry
            binding.entryText.text = entry.entryText
            binding.entryTitle.text = entry.entryTitle
            binding.date.text = entry.dateOfEntry
        }
}