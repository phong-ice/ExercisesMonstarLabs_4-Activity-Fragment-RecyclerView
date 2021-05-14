package com.example.exercise_activity_fragment_recyclerview.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.activity.Login
import com.example.exercise_activity_fragment_recyclerview.activity.Main
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentOnboarding3Binding
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationOnBoarding

class Onboarding3(var listener: CommunicationOnBoarding) : Fragment() {

    private val binding: FragmentOnboarding3Binding by lazy {
        FragmentOnboarding3Binding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnNext.setOnClickListener {
            startActivity(Intent(requireContext(), Login::class.java))
            listener.saveStatusOnBoarding()
        }
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(requireContext(), Login::class.java))
            listener.saveStatusOnBoarding()
        }
    }

}