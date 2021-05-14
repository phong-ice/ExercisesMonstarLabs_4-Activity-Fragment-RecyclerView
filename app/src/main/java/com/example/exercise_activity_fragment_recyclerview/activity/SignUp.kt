package com.example.exercise_activity_fragment_recyclerview.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exercise_activity_fragment_recyclerview.R
import com.example.exercise_activity_fragment_recyclerview.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(
            layoutInflater
        )
    }

    private lateinit var sharedPreferences:SharedPreferences

    companion object {
        val KEY_EMAIL = "key_email"
        val KEY_PASSWORD = "key_password"
        val KEY = "key_password"
        val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val email: String = binding.edtEmail.text.toString()
            val password: String = binding.edtPassword.text.toString()
            when (email) {
                "" -> binding.edtEmail.error = "Require email"
                else -> {
                    when {
                        EMAIL_ADDRESS_PATTERN.matcher(email).matches() -> {
                            when(password){
                                "" -> {
                                    binding.edtPassword.error = "Require password"
                                }
                                else -> {
                                    sharedPreferences = getSharedPreferences(KEY, MODE_PRIVATE)
                                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                                    editor.putString(KEY_EMAIL, email)
                                    editor.putString(KEY_PASSWORD, password)
                                    editor.apply()
                                    var intent = Intent(this, Login::class.java)
                                    intent.putExtra("email",email)
                                    intent.putExtra("password",password)
                                    startActivity(intent)
                                    finish()
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
        }
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

    }

}