package com.example.pokesd.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pokesd.R
import com.example.pokesd.ui.registration.RegistrationActivity
import com.example.pokesd.ui.welcome.WelcomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val usernameEt = findViewById<EditText>(R.id.editTextText)
        val passwordEt = findViewById<EditText>(R.id.editTextTextPassword)
        val loginBtn = findViewById<Button>(R.id.button)

        // 🔹 NEW: Sign Up TextView
        val signUpText = findViewById<TextView>(R.id.textView8)

        loginBtn.setOnClickListener {
            viewModel.login(
                usernameEt.text.toString(),
                passwordEt.text.toString()
            )
        }

        // 🔹 NEW: Navigate to Registration screen
        signUpText.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        viewModel.loginResult.observe(this) { result ->
            result.errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

            if (result.success) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", usernameEt.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
