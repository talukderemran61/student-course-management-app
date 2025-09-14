package com.example.myassssmentapplication

data class Entity(
    val courseCode: String,
    val courseName: String,
    val instructor: String,
    val credits: Int,
    val description: String
)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)
