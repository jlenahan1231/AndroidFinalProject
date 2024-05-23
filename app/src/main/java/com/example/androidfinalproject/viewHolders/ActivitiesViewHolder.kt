package com.example.androidfinalproject.viewHolders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ActvititiesItemLayoutBinding
import com.example.androidfinalproject.dataclasses.Activity

class ActivitiesViewHolder(val binding: ActvititiesItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentActivity: Activity

    @SuppressLint("SetTextI18n")
    fun bindActivity(activity: Activity){
        currentActivity = activity
        binding.textViewActivityTitle.text = activity.activityName
        binding.address.text = activity.location
        binding.amountPerWeek.text = activity.timesPerWeek.toString() + " Times/Week"
    }
}