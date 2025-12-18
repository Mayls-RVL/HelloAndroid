package com.example.helloandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            showToast()
        }
    }
     fun showToast() {
        Toast.makeText(this, "Button clicked! Congrats!", Toast.LENGTH_SHORT).show()
    }
}
