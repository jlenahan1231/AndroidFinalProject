package com.example.androidfinalproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.JournalItemLayoutBinding
import com.example.androidfinalproject.dataclasses.Journal
import com.example.androidfinalproject.viewHolders.JournalViewHolder

class JournalAdapter(val journalList: List<Journal>) : RecyclerView.Adapter<JournalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val binding = JournalItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JournalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return journalList.size
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        val currentEntry = journalList[position]
        holder.bindEntry(currentEntry)
    }

}