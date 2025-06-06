package com.kaviriteshgupta.log_my_reps.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.SportsGymnastics
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.kaviriteshgupta.log_my_reps.ui.theme.LogmyrepsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogmyrepsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        val graph = navController.createGraph(startDestination = Screen.WorkoutPlan.route) {
            composable(route = Screen.History.route) {
                HistoryScreen()
            }
            composable(route = Screen.WorkoutPlan.route) {
                WorkoutPlanScreen()
            }
            composable(route = Screen.Exercise.route) {
                ExercisesScreen()
            }
            composable(route = Screen.Measurement.route) {
                MeasurementScreen()
            }
        }

        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {

}

@Composable
fun WorkoutPlanScreen(modifier: Modifier = Modifier) {

}

@Composable
fun ExercisesScreen(modifier: Modifier = Modifier) {

}

@Composable
fun MeasurementScreen(modifier: Modifier = Modifier) {

}
