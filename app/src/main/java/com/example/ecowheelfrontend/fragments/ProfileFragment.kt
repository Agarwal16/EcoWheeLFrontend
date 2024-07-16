package com.example.ecowheelfrontend.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ecowheelfrontend.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Find views and set click listeners
        val editProfileButton: Button = view.findViewById(R.id.editProfileButton)
        val settingsOption: TextView = view.findViewById(R.id.settingsOption)
        val billingDetailsOption: TextView = view.findViewById(R.id.billingDetailsOption)
        val userManagementOption: TextView = view.findViewById(R.id.userManagementOption)
        val informationOption: TextView = view.findViewById(R.id.informationOption)
        val logoutOption: TextView = view.findViewById(R.id.logoutOption)

        editProfileButton.setOnClickListener {
            // Handle edit profile button click
            Toast.makeText(context, "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        }

        settingsOption.setOnClickListener {
            // Handle settings option click
            Toast.makeText(context, "Settings Clicked", Toast.LENGTH_SHORT).show()
        }

        billingDetailsOption.setOnClickListener {
            // Handle billing details option click
            Toast.makeText(context, "Billing Details Clicked", Toast.LENGTH_SHORT).show()
        }

        userManagementOption.setOnClickListener {
            // Handle user management option click
            Toast.makeText(context, "User Management Clicked", Toast.LENGTH_SHORT).show()
        }

        informationOption.setOnClickListener {
            // Handle information option click
            Toast.makeText(context, "Information Clicked", Toast.LENGTH_SHORT).show()
        }

        logoutOption.setOnClickListener {
            // Handle logout option click
            Toast.makeText(context, "Logout Clicked", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}