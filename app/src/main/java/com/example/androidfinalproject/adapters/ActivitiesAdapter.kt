package com.example.androidfinalproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ActvititiesItemLayoutBinding
import com.example.androidfinalproject.dataclasses.Activity
import com.example.androidfinalproject.viewHolders.ActivitiesViewHolder

class ActivitiesAdapter(val actvitiesList: List<Activity>) : RecyclerView.Adapter<ActivitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val binding = ActvititiesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivitiesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return actvitiesList.size
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val currentActivity = actvitiesList[position]
        holder.bindActivity(currentActivity)
    }
}