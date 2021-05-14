package com.example.exercise_activity_fragment_recyclerview.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentNewArticleDetailsBinding

class NewsArticleDetails : Fragment() {

    private val binding: FragmentNewArticleDetailsBinding by lazy {
        FragmentNewArticleDetailsBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("testFragment","${parentFragmentManager.backStackEntryCount} : ${childFragmentManager.backStackEntryCount} 123")
        binding.tvContent.setText(arguments?.getString("contentNews").toString())
        binding.tvDate.text = arguments?.getString("dateNews").toString()
    }
}