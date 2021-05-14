package com.example.exercise_activity_fragment_recyclerview

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.exercise_activity_fragment_recyclerview.activity.Login
import com.example.exercise_activity_fragment_recyclerview.activity.Main
import com.example.exercise_activity_fragment_recyclerview.fragment.Onboarding1
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationOnBoarding
import java.security.Key

class MainActivity : AppCompatActivity(), CommunicationOnBoarding {
    private lateinit var sharedPreferences: SharedPreferences
    private val KEY_ONBOARDING = "key_onboarding"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(KEY_ONBOARDING, MODE_PRIVATE)
        var isOnBoarding: Boolean = sharedPreferences.getBoolean(KEY_ONBOARDING, false)

                when{
                    isOnBoarding -> {
                        startActivity(Intent(this,Login::class.java))
                        finish()
                    }

                    else -> {
                        setContentView(R.layout.activity_main)
                        addFragment(Onboarding1(this), "Onboarding1")
                    }
                }
    }

    private fun addFragment(fr: Fragment, name: String) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_onboarding, fr, name)
        transaction.addToBackStack(name)
        transaction.commit()

    }

    override fun changeSelectedNavBottom(fr: Fragment, name: String) {
        addFragment(fr, name)
    }

    override fun saveStatusOnBoarding() {
        sharedPreferences = getSharedPreferences(KEY_ONBOARDING, MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(KEY_ONBOARDING, true)
        editor.apply()
    }

}