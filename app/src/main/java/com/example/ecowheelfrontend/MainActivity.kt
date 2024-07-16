package com.example.ecowheelfrontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ecowheelfrontend.databinding.ActivityMainBinding
import com.example.ecowheelfrontend.fragments.HomeFragment
import com.example.ecowheelfrontend.fragments.MapFragment
import com.example.ecowheelfrontend.fragments.NotificationFragment
import com.example.ecowheelfrontend.fragments.PlanFragment
import com.example.ecowheelfrontend.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize with the PlanFragment
        if (savedInstanceState == null) {
            loadFragment(PlanFragment())
        }

        // Set label visibility for BottomNavigationView
        binding.bottomNavigation.labelVisibilityMode = BottomNavigationView.LABEL_VISIBILITY_LABELED

        // Set badge for Notification icon
        binding.bottomNavigation.getOrCreateBadge(R.id.nav_notifications).apply {
            isVisible = true
            number = 5
        }

        // Set listener for BottomNavigationView item selection
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_map -> MapFragment()
                R.id.nav_plan -> PlanFragment()
                R.id.nav_notifications -> NotificationFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> null
            }
            fragment?.let {
                loadFragment(it)
                true
            } ?: false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
