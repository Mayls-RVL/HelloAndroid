package com.example.myprofile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button click
        val button: Button = findViewById(R.id.button1)
        button.setOnClickListener {
            showToast()
        }

        // Personal Information toggle
        val itemTitle = findViewById<View>(R.id.itemTitle)
        val itemContent = findViewById<LinearLayout>(R.id.itemContent)
        val itemArrow = findViewById<ImageView>(R.id.itemArrow)

        itemTitle.setOnClickListener {
            if (itemContent.visibility == View.GONE) {
                itemContent.visibility = View.VISIBLE
                itemArrow.rotation = 180f
            } else {
                itemContent.visibility = View.GONE
                itemArrow.rotation = 0f
            }
        }

        // Education toggle
        val educationTitle = findViewById<View>(R.id.educationTitle)
        val educationContent = findViewById<LinearLayout>(R.id.educationContent)
        val educationArrow = findViewById<ImageView>(R.id.educationArrow)

        educationTitle.setOnClickListener {
            if (educationContent.visibility == View.GONE) {
                educationContent.visibility = View.VISIBLE
                educationArrow.rotation = 180f
            } else {
                educationContent.visibility = View.GONE
                educationArrow.rotation = 0f
            }
        }

        // Hobbies toggle
        val hobbiesTitle = findViewById<View>(R.id.hobbiesTitle)
        val hobbiesContent = findViewById<LinearLayout>(R.id.hobbiesContent)
        val hobbiesArrow = findViewById<ImageView>(R.id.hobbiesArrow)

        hobbiesTitle.setOnClickListener {
            if (hobbiesContent.visibility == View.GONE) {
                hobbiesContent.visibility = View.VISIBLE
                hobbiesArrow.rotation = 180f
            } else {
                hobbiesContent.visibility = View.GONE
                hobbiesArrow.rotation = 0f
            }
        }
    }

    private fun showToast() {
        Toast.makeText(this, "That Feature is Coming Soon!!", Toast.LENGTH_SHORT).show()
    }
}
