package com.example.miniprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class InfoFragment : Fragment() {

    companion object {
        fun newInstance(type: String): InfoFragment {
            val fragment = InfoFragment()
            fragment.arguments = Bundle().apply {
                putString("type", type)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val titleText = view.findViewById<TextView>(R.id.titleText)
        val contentText = view.findViewById<TextView>(R.id.contentText)

        when (arguments?.getString("type")) {
            "personal" -> {
                titleText.text = "Personal Information"
                contentText.text = "Name: Roshinwel Myles V. Larga\n\n" +
                        "Address: Manila City, Manila, NCR, Philippines\n\n" +
                        "Birthdate: April 15, 2002\n\n" +
                        "Age: 23 Years Old\n\n" +
                        "Marital Status: Single"
            }
            "education" -> {
                titleText.text = "Education"
                contentText.text = "Degree: Bachelor's Degree\n\n" +
                        "Program: Information Technology\n\n" +
                        "University: Polytechnic University of the Philippines\n\n" +
                        "Branch: Main Branch"
            }
            "hobbies" -> {
                titleText.text = "Hobbies"
                contentText.text = "Gaming (LoL, Valorant, ABI, Peak)\n\n" +
                        "Watching Movies/Series\n\n" +
                        "Sports(Volleyball, Billiards, Basketball)"
            }
        }

        return view
    }
}

