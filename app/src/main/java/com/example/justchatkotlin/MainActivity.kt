package com.example.justchatkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        button_register.setOnClickListener {
            performRegister()
        }

        already_have_account_textView.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister() {
        val usernameRegister = username_register.text.toString()
        val passwordRegister = password_register.text.toString()
        val mailRegister = mail_register.text.toString()

        Log.d("MainActivity", "email is $mailRegister")
        Log.d("MainActivity", "name is $usernameRegister")
        Log.d("MainActivity", "password is $passwordRegister")

        if (mailRegister.isEmpty() || usernameRegister.isEmpty() || passwordRegister.isEmpty()) {
            Toast.makeText(this, "Please enter data into all fields.", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(mailRegister, passwordRegister)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Main", "createUserWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Main", "createUserWithEmail:failure", task.exception)
                }
            }
            .addOnFailureListener(this) {task ->
                Toast.makeText(baseContext, "${task.message}",
                    Toast.LENGTH_SHORT).show()
            }
    }
}