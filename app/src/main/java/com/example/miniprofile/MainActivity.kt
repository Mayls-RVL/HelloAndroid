package com.example.miniprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1️⃣ Set default fragment (ProfileFragment)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ProfileFragment())
            .commit()

        // 2️⃣ Find the BottomNavigationView
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // 3️⃣ Handle menu item clicks
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProfileFragment())
                        .commit()
                    true
                }
                R.id.menu_personal -> {
                    val fragment = InfoFragment()
                    fragment.arguments = Bundle().apply { putString("type", "personal") }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                R.id.menu_education -> {
                    val fragment = InfoFragment()
                    fragment.arguments = Bundle().apply { putString("type", "education") }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                R.id.menu_hobbies -> {
                    val fragment = InfoFragment()
                    fragment.arguments = Bundle().apply { putString("type", "hobbies") }
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
