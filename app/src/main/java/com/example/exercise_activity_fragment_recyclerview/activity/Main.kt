package com.example.exercise_activity_fragment_recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.fragment.Coin
import com.example.exercise_activity_fragment_recyclerview.fragment.Customer
import com.example.exercise_activity_fragment_recyclerview.fragment.Home
import com.example.exercise_activity_fragment_recyclerview.fragment.News
import com.example.exercise_activity_fragment_recyclerview.untils.CommunicationFragmentWithMain
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.*

class Main : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        addFragment(Home(), "Home")

        nav_bottom_main.itemIconTintList = null

        nav_bottom_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_fragment -> {
                    addFragment(Home(), "Home")
                }
                R.id.coin_fragment -> {
                    addFragment(Coin(), "Coin")
                }
                R.id.news_fragment -> {
                    addFragment(News(), "News")
                }
                R.id.costomer_fragment -> {
                    addFragment(Customer(), "Costomer")
                }
            }
            true
        }
    }

    private fun addFragment(fr: Fragment, name: String) {
        if (supportFragmentManager.findFragmentByTag(name) == null) {
            var transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.host_fragment_main, fr, name)
            transaction.addToBackStack(name)
            transaction.commit()
        } else {
            supportFragmentManager.popBackStack(name, 0)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            val dialog = AlertDialog.Builder(this@Main)
            dialog.setTitle("Alert")
            dialog.setMessage("Are you sure?")
            dialog.setPositiveButton("Exits") { dialog, which ->
                finish()
            }
            dialog.setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            dialog.show()
        } else {
            super.onBackPressed()
            var index = supportFragmentManager.backStackEntryCount - 1
            var backEntry = supportFragmentManager.getBackStackEntryAt(index);
            var tag = backEntry.name;
            var fragment = supportFragmentManager.findFragmentByTag(tag);

            when (fragment) {
                supportFragmentManager.findFragmentByTag("Home") -> {
                    nav_bottom_main.getMenu().findItem(R.id.home_fragment).setChecked(true);
                }
                supportFragmentManager.findFragmentByTag("Coin") -> {
                    nav_bottom_main.getMenu().findItem(R.id.coin_fragment).setChecked(true);
                }
                supportFragmentManager.findFragmentByTag("News") -> {
                    nav_bottom_main.getMenu().findItem(R.id.news_fragment).setChecked(true);
                }
                supportFragmentManager.findFragmentByTag("Costomer") -> {
                    nav_bottom_main.getMenu().findItem(R.id.costomer_fragment).setChecked(true);
                }
            }
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}