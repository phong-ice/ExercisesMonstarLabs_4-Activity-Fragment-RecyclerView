package com.example.exercise_activity_fragment_recyclerview.untils

import androidx.fragment.app.Fragment

interface CommunicationOnBoarding {
    fun changeSelectedNavBottom(fr: Fragment,name:String)
    fun saveStatusOnBoarding()
}