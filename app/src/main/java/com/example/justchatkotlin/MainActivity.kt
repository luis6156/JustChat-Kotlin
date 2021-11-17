package com.example.justchatkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_register.setOnClickListener {
            val usernameRegister = username_register.text.toString()
            val passwordRegister = password_register.text.toString()
            val mailRegister = mail_register.text.toString()

            Log.d("MainActivity", "email is $mailRegister")
            Log.d("MainActivity", "name is $usernameRegister")
            Log.d("MainActivity", "password is $passwordRegister")
        }

        already_have_account_textView.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}