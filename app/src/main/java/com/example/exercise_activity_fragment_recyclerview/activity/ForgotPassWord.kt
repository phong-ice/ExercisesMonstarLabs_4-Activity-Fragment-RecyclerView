package com.example.exercise_activity_fragment_recyclerview.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.activity.SignUp.Companion.KEY
import com.example.exercise_activity_fragment_recyclerview.databinding.ActivityForgotPassWordBinding

class ForgotPassWord : AppCompatActivity() {

    private lateinit var sharedPreferences:SharedPreferences

    private val binding: ActivityForgotPassWordBinding by lazy {
        ActivityForgotPassWordBinding.inflate(
            layoutInflater
        )
    }
    private var timeStart = 30
    private lateinit var handler: Handler
    private val runnable: Runnable by lazy {
        Runnable {
            if (timeStart > 0) {
                timeStart--
                runOnUiThread {
                    binding.tvCountDown.text = "Wait $timeStart seconds before sending it"
                }
                handler.postDelayed(runnable, 1000)
            } else {
                var intent = Intent(this, LoginNow::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    private val handlerThread = HandlerThread("myThread")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(SignUp.KEY_PASSWORD, "123")
        editor.apply()

        binding.btnResendEmail.setOnClickListener {
            startActivity(Intent(this, LoginNow::class.java))
            finish()
        }

        handlerThread.start()
        handler = Handler(handlerThread.looper)
        handler.postDelayed(runnable, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        handlerThread.quit()
    }
}