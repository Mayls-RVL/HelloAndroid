package com.example.tabs

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: AppCompatActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = listOf(
        LifestyleFragment(),
        FitnessFragment(),
        HealthFragment()
    )

    private val fragmentTitleList = listOf(
        "Lifestyle",
        "Fitness",
        "Health"
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun getTitle(position: Int): String = fragmentTitleList[position]
}
