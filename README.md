# Student Course Management App

This Android app is a simple **course management system** built with Kotlin.  
It demonstrates:
- User login with student ID
- Dashboard with course list
- Course detail view
- RecyclerView for displaying entities
- **Dependency Injection with Hilt** (to meet project requirements)

---

## Project Structure
- `MainActivity.kt` → Handles login
- `DashboardActivity.kt` → Displays list of courses
- `DetailsActivity.kt` → Shows course details
- `data/` → Contains `CourseRepository` and data classes
- `di/` → Contains Hilt modules
- `adapter/` → RecyclerView adapter for courses
- `res/layout/` → XML layout files

---

##  Tech Stack
- **Kotlin**
- **Android Jetpack**
    - RecyclerView
    - ViewBinding
- **Hilt for Dependency Injection**
- MVVM-style separation (basic)

---

## Setup Instructions

1. Clone or download the project.

2. Open it in **Android Studio**.

3. Make sure your **Gradle version** is up to date.

4. Open **Device Manager** Create a virtual device

5. Run the **App**