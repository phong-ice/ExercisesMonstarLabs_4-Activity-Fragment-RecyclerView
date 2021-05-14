package com.example.exercise_activity_fragment_recyclerview.untils

import androidx.fragment.app.Fragment
import com.example.exercise_activity_fragment_recyclerview.model.NewsArticle

interface CommunicationFragmentNews {
    fun itemOnClick(newArticle:NewsArticle, fr: Fragment, name:String)
}