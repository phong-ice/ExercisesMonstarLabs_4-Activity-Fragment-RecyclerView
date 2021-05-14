package com.example.exercise_activity_fragment_recyclerview.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.databinding.ActivityLoginNowBinding

class LoginNow : AppCompatActivity() {

    private val binding:ActivityLoginNowBinding by lazy { ActivityLoginNowBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}