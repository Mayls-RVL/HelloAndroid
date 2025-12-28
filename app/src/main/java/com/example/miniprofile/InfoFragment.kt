package com.example.miniprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val titleText = view.findViewById<TextView>(R.id.titleText)
        val contentText = view.findViewById<TextView>(R.id.contentText)

        val type = arguments?.getString("type")

        when (type) {
            "personal" -> {
                titleText.text = "Personal Information"
                contentText.text =
                    "Name: Roshinwel Myles V. Larga \n\n" +
                            "Address: Dulong Bayan, Bacoor City, Philippines\n\n" +
                            "Marital Status: Single\n\n\n\n"
            }

            "education" -> {
                titleText.text = "Education"
                contentText.text =
                    "Degree: Bachelor’s Degree\n\n" +
                            "Program: Information Technology\n\n" +
                            "University: Polytechnic University of the Philippines\n\n" +
                            "Branch: Main Campus\n\n\n\n"
            }

            "hobbies" -> {
                titleText.text = "Hobbies"
                contentText.text =
                    "• Gaming\n" +
                            "• Watching Movies/Series\n" +
                            "• Sports(Volleyball, Billiards, Basketball)\n\n\n\n"
            }
        }

        // -------------------------------
        // Back button logic
        val backButton = view.findViewById<Button>(R.id.buttonBack)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()  // returns to previous screen
        }
        // -------------------------------

        return view
    }
}
