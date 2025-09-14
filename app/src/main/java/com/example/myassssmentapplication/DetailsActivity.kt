package com.example.myassssmentapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvCourseCode: TextView = findViewById(R.id.tvCourseCode)
        val tvCourseName: TextView = findViewById(R.id.tvCourseName)
        val tvInstructor: TextView = findViewById(R.id.tvInstructor)
        val tvCredits: TextView = findViewById(R.id.tvCredits)
        val tvDescription: TextView = findViewById(R.id.tvDescription)

        // Get data passed from DashboardActivity
        val courseCode = intent.getStringExtra("courseCode")
        val courseName = intent.getStringExtra("courseName")
        val instructor = intent.getStringExtra("instructor")
        val credits = intent.getIntExtra("credits", 0)
        val description = intent.getStringExtra("description")

        // Display them
        tvCourseCode.text = "Course Code: $courseCode"
        tvCourseName.text = "Course Name: $courseName"
        tvInstructor.text = "Instructor: $instructor"
        tvCredits.text = "Credits: $credits"
        tvDescription.text = "Description:\n$description"
    }
}
