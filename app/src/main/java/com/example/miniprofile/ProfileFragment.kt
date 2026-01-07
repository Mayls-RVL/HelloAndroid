package com.example.miniprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.profileRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val items = listOf(
            ProfileItem("Personal Information", "personal"),
            ProfileItem("Education", "education"),
            ProfileItem("Hobbies", "hobbies")
        )

        val adapter = ProfileAdapter(items) { item ->
            val fragment = InfoFragment.newInstance(item.type)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter

        return view
    }
}
