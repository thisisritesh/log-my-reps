package com.kaviriteshgupta.log_my_reps.ui

sealed class Screen(val route: String) {
    data object History : Screen("history_screen")
    data object WorkoutPlan : Screen("workout_plan_screen")
    data object Exercise : Screen("exercise_screen")
    data object Measurement : Screen("measurement_screen")
}