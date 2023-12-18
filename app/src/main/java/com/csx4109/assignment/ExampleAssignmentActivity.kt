package com.csx4109.assignment

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding

/**
 * Page Name: Counting Game
 *
 * -- Description --
 * Create an app that has
 * - textView named `tvCounter`
 * - button named `btnPlus`
 * - button named `btnMinus`
 *
 * Cases
 * - When open an application, the first value in `tvCounter` should be 0
 * - When click `btnPlus`, `tvCounter` should be increased by 1
 * - When click `btnMinus`, `tvCounter` should be decreased by 1
 */
/**
class ExampleAssignmentActivity : AppCompatActivity() {
    private val view: ActivityExampleAssignmentBinding by lazy { ActivityExampleAssignmentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_assignment)

        // Set click listeners for the buttons
        view.btnPlus.setOnClickListener {
            // Increase the counter by 1 when btnPlus is clicked
            val newView = view.tvCounter.text.toString().toInt()+1
            view.tvCounter.text = newView.toString()
        }

        view.btnMinus.setOnClickListener {
            // Decrease the counter by 1 when btnMinus is clicked
            val newView = view.tvCounter.text.toString().toInt()-1
            view.tvCounter.text = newView.toString()
        }
    }


    }*/


class ExampleAssignmentActivity : AppCompatActivity() {
private val view: ActivityExampleAssignmentBinding by lazy { ActivityExampleAssignmentBinding.inflate(layoutInflater) }

@SuppressLint("SetTextI18n")
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(view.root)

// Set initial value for tvCounter
view.tvCounter.text = "0"

// Set click listeners for the buttons
view.btnPlus.setOnClickListener {
// Increase the counter by 1 when btnPlus is clicked
view.tvCounter.text = (view.tvCounter.text.toString().toInt() + 1).toString()
}

view.btnMinus.setOnClickListener {
// Decrease the counter by 1 when btnMinus is clicked
view.tvCounter.text = (view.tvCounter.text.toString().toInt() - 1).toString()
}
}
}
