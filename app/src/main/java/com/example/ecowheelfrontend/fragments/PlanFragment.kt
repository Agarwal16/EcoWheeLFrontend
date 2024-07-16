package com.example.ecowheelfrontend.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ecowheelfrontend.R
import com.example.ecowheelfrontend.adapter.ImageSliderAdapter
import java.text.SimpleDateFormat
import java.util.*

class PlanFragment : Fragment() {

    private lateinit var cycleImageSlider: ViewPager2
    private lateinit var planOptions: Spinner
    private lateinit var totalAmount: TextView
    private lateinit var startDateTextView: TextView
    private lateinit var finalDateTextView: TextView

    private val planPrices = mapOf("6 Months" to 599, "12 Months" to 999)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_plan, container, false)

        cycleImageSlider = view.findViewById(R.id.cycleImageSlider)
        planOptions = view.findViewById(R.id.planOptions)
        totalAmount = view.findViewById(R.id.totalAmount)
        startDateTextView = view.findViewById(R.id.startDate)
        finalDateTextView = view.findViewById(R.id.finalDate)

        setupToolbar(view)
        setupCycleImageSlider()
        setupPlanOptions()
        setupInitialDates()

        return view
    }

    private fun setupToolbar(view: View) {
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.title = "Rent a Bicycle"
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
        toolbar.setBackgroundColor(resources.getColor(R.color.main))
        toolbar.elevation = 4f
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
    }

    private fun setupCycleImageSlider() {
        val images = listOf(
            R.drawable.cycle_image5r,
            R.drawable.cycle_image4r,
            R.drawable.cycle_image3r,
            R.drawable.cycle_image2r,
            R.drawable.cycle_image1r
        )
        val adapter = ImageSliderAdapter(images)
        cycleImageSlider.adapter = adapter
    }

    private fun setupPlanOptions() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            planPrices.keys.toList()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        planOptions.adapter = adapter

        planOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedPlan = parent.getItemAtPosition(position) as String
                val price = planPrices[selectedPlan] ?: 0
                val total = price + 1000
                totalAmount.text = "Total Amount: ₹ $total"
                calculateDates(selectedPlan)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun setupInitialDates() {
        val currentDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date())
        startDateTextView.text = "Start Date: $currentDate"
    }

    private fun calculateDates(selectedPlan: String) {
        val calendar = Calendar.getInstance()

        // Calculate final date based on selected plan
        val months = if (selectedPlan == "6 Months") 6 else 12
        calendar.add(Calendar.MONTH, months)
        val finalDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(calendar.time)

        finalDateTextView.text = "Final Date: $finalDate"
    }
}
