package com.example.androidfinalproject.viewHolders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ClassesItemLayoutBinding
import com.example.androidfinalproject.dataclasses.SchoolClass

class ClassesViewHolder(val binding: ClassesItemLayoutBinding):
    RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentClass: SchoolClass

        @SuppressLint("SetTextI18n")
        fun bindClass(schoolClass: SchoolClass){
            currentClass = schoolClass
            binding.textViewClassTitle.text = currentClass.clasName
            binding.textViewCourseInstructor.text = currentClass.teacher
            binding.difficulty.text = "Diff: " + currentClass.difficulty.toString() + "/10"
            binding.period.text = "Period" + currentClass.period.toString()
        }
}