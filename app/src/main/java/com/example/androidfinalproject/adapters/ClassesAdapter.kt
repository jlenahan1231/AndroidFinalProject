package com.example.androidfinalproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ClassesItemLayoutBinding
import com.example.androidfinalproject.dataclasses.SchoolClass
import com.example.androidfinalproject.viewHolders.ClassesViewHolder

class ClassesAdapter(val classesList: List<SchoolClass>): RecyclerView.Adapter<ClassesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val binding = ClassesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return classesList.size
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val currentSchoolClass = classesList[position]
        holder.bindClass(currentSchoolClass)
    }
}