package com.example.justchatkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        button_login.setOnClickListener {
            val mailLogin = mail_login.text.toString()
            val passwordLogin = password_login.text.toString()

            Log.d("LoginActivity", "email is $mailLogin")
            Log.d("LoginActivity", "name is $passwordLogin")

            auth.signInWithEmailAndPassword(mailLogin, passwordLogin)
                .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Login", "signInWithEmail:failure", task.exception)
                }
                }
                .addOnFailureListener(this) {task ->
                    Toast.makeText(baseContext, "${task.message}",
                        Toast.LENGTH_SHORT).show()
                }
        }

        need_an_account_textView.setOnClickListener {
            Log.d("LoginActivity", "Try to show register/main activity")

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}