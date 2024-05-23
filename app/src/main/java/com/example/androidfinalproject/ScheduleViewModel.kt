package com.example.androidfinalproject

import androidx.fragment.app.viewModels
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.androidfinalproject.dataclasses.Activity
import com.example.androidfinalproject.dataclasses.Journal
import com.example.androidfinalproject.dataclasses.SchoolClass

class ScheduleViewModel: ViewModel() {

    val entryList = mutableListOf(Journal("School", "AAAAAAAAAAAAAAAA", "11/22/63"), Journal("Lifting", "GRRRRRRRRRRR", "12/31/05"))
    val classList = mutableListOf(SchoolClass("Math", "Doc Williams", 1, 7), SchoolClass("Comp Sci", "Sedon", 7, 1))
    var activityList = mutableListOf(Activity("Baseball", 6, "222 Noble Road"), Activity("Lifting", 3, "333 Imagine Land"),
        Activity("Brazilian Jiu Jitsu", 2, "1800 Columbus Boulevard"))
    fun addJournal(entryTitle: String, entryText: String, dateOfEntry: String){
        entryList.add(Journal(entryTitle, entryText, dateOfEntry))
    }

    fun addNewClass(className: String, teacherName: String, period: Int, difficulty: Int){
        classList.add(SchoolClass(className, teacherName, period, difficulty))
    }

    fun addActivity(activityName: String, timesPerWeek: Int, address: String){
        activityList.add(Activity(activityName, timesPerWeek, address))
    }
}