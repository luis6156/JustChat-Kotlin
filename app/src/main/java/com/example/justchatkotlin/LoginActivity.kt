package com.example.justchatkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            val usernameLogin = username_login.text.toString()
            val passwordLogin = password_login.text.toString()

            Log.d("LoginActivity", "email is $usernameLogin")
            Log.d("LoginActivity", "name is $passwordLogin")
        }

        need_an_account_textView.setOnClickListener {
            Log.d("LoginActivity", "Try to show register/main activity")

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}