package com.kaviriteshgupta.log_my_reps.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.kaviriteshgupta.log_my_reps.ui.theme.BgColor
import com.kaviriteshgupta.log_my_reps.ui.theme.PrimaryColor
import com.kaviriteshgupta.log_my_reps.ui.theme.TextColor


@Composable
fun BottomNavigationBar(navController: NavController) {

    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(1) }

    val navItems = listOf(
        NavItem("History", Icons.Default.History, Screen.History.route),
        NavItem("Workout Plan", Icons.Default.Description, Screen.WorkoutPlan.route),
        NavItem("Exercises", Icons.Default.FitnessCenter, Screen.Exercise.route),
        NavItem("Measurements", Icons.Default.MonitorWeight, Screen.Measurement.route)
    )

    NavigationBar(containerColor = BgColor) {
        navItems.forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.title)
                },
                label = {
                    Text(
                        text = navItem.title,
                        color = if (selectedNavigationIndex.intValue == index) PrimaryColor else TextColor,
                        style = MaterialTheme.typography.displaySmall
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = PrimaryColor,
                    selectedTextColor = PrimaryColor,
                    selectedIndicatorColor = PrimaryColor,
                    unselectedIconColor = TextColor,
                    unselectedTextColor = TextColor,
                    disabledIconColor = TextColor,
                    disabledTextColor = TextColor
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)