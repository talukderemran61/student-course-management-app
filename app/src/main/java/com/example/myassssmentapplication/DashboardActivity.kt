package com.example.myassssmentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var tvTotal: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvTotal = findViewById(R.id.tvTotal)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val keypass = intent.getStringExtra("keypass") ?: ""

        // ✅ Call dashboard API
        RetrofitClient.instance.getDashboard(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    val dashboardResponse = response.body()
                    val entities = dashboardResponse?.entities ?: emptyList()

                    // Show total number
                    tvTotal.text = "Total items: ${dashboardResponse?.entityTotal ?: 0}"

                    // Setup RecyclerView
                    val adapter = EntityAdapter(entities) { entity ->
                        // Navigate to DetailsActivity
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                        intent.putExtra("courseCode", entity.courseCode)
                        intent.putExtra("courseName", entity.courseName)
                        intent.putExtra("instructor", entity.instructor)
                        intent.putExtra("credits", entity.credits)
                        intent.putExtra("description", entity.description)
                        startActivity(intent)
                    }

                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load dashboard", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
