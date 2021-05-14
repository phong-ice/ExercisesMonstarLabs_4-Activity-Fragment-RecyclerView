package com.example.exercise_activity_fragment_recyclerview.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.activity.Login
import com.example.exercise_activity_fragment_recyclerview.activity.Main
import com.example.exercise_activity_fragment_recyclerview.databinding.FragmentOnboarding1Binding
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationOnBoarding

class Onboarding1(var listener: CommunicationOnBoarding) : Fragment() {

    private val binding: FragmentOnboarding1Binding by lazy {
        FragmentOnboarding1Binding.inflate(
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
            listener.changeSelectedNavBottom(Onboarding2(listener), "Onboarding2")
        }
        binding.tvSkip.setOnClickListener {
            listener.saveStatusOnBoarding()
            startActivity(Intent(requireContext(), Login::class.java))
        }
    }

    private fun addFragment(fr: Fragment, name: String) {
        var transaction = parentFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_onboarding, fr, name)
        transaction.addToBackStack(name)
        transaction.commit()
    }


}