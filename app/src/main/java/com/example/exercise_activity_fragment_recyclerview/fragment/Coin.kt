package com.example.exercise_activity_fragment_recyclerview.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_coin.*


class Coin() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i("testbackStack", "${parentFragmentManager.backStackEntryCount}")
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_back.setOnClickListener {
            parentFragmentManager.popBackStack()
            var index = parentFragmentManager.backStackEntryCount - 2
            var backEntry = parentFragmentManager.getBackStackEntryAt(index);
            var tag = backEntry.name;
            var fragment = parentFragmentManager.findFragmentByTag(tag);
            Log.i("asdasd","${fragment}")
            when(fragment){
                parentFragmentManager.findFragmentByTag("Home") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.home_fragment)?.setChecked(true);
                }
                parentFragmentManager.findFragmentByTag("Costomer") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.coin_fragment)?.setChecked(true);
                }
                parentFragmentManager.findFragmentByTag("News") -> {
                    activity?.nav_bottom_main?.getMenu()?.findItem(R.id.news_fragment)?.setChecked(true);
                }
            }
        }
    }
}