package com.example.exercise_activity_fragment_recyclerview.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exercise_activity_fragment_recyclerview.MainActivity
import com.example.exercise_activity_fragment_recyclerview.activity.SignUp.Companion.KEY_EMAIL
import com.example.exercise_activity_fragment_recyclerview.activity.SignUp.Companion.KEY_PASSWORD
import com.example.exercise_activity_fragment_recyclerview.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (intent.getStringExtra("email").toString() != "null") {
            binding.edtEmail.setText(intent.getStringExtra("email").toString())
            binding.edtPassword.setText(intent.getStringExtra("password").toString())
        }

        binding.btnLogin.setOnClickListener {
            sharedPreferences = getSharedPreferences(SignUp.KEY, MODE_PRIVATE)
            val emailAvailable = sharedPreferences.getString(KEY_EMAIL, "")
            val passwordAvailable = sharedPreferences.getString(KEY_PASSWORD, "")
            val email: String = binding.edtEmail.text.toString()
            val password: String = binding.edtPassword.text.toString()
            when (email) {
                "" -> binding.edtEmail.error = "Require email"
                else -> {
                    when {
                        SignUp.EMAIL_ADDRESS_PATTERN.matcher(email).matches() -> {
                            when (emailAvailable) {
                                email -> {
                                    when (password) {
                                        "" -> {
                                            binding.edtPassword.error = "Require password"
                                        }
                                        else -> {
                                            when (passwordAvailable) {
                                                password -> {
                                                    startActivity(Intent(this, Main::class.java))
                                                    finish()
                                                }
                                                else -> {
                                                    binding.edtPassword.error = "Password incorrect"
                                                }
                                            }

                                        }
                                    }
                                }
                                else -> {
                                    binding.edtEmail.error = "Email not available"
                                }
                            }
                        }
                        else -> binding.edtEmail.error = "Email Invalid"
                    }
                }
            }

        }
        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPassWord::class.java))
            finish()
        }
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}