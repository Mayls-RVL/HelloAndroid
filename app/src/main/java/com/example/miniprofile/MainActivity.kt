package com.example.miniprofile

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.arrowPersonal).setOnClickListener {
            openFragment("personal")
        }

        findViewById<ImageView>(R.id.arrowEducation).setOnClickListener {
            openFragment("education")
        }

        findViewById<ImageView>(R.id.arrowHobbies).setOnClickListener {
            openFragment("hobbies")
        }
    }

    private fun openFragment(type: String) {
        val fragment = InfoFragment()

        val bundle = Bundle()
        bundle.putString("type", type)
        fragment.arguments = bundle

        // 🔑 THIS IS THE IMPORTANT CHANGE
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .addToBackStack(null)
            .commit()
    }
}
