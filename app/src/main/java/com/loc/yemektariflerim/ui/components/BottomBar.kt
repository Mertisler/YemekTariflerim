package com.loc.yemektariflerim.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.loc.yemektariflerim.navigation.Screen
import java.util.Locale

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        Screen.Home
    )
    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = { Icon(Icons.Default.Home, contentDescription = screen.route) },
                label = {
                    Text(

                        screen.route.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                        }
                    )
                }
            )
        }
    }
}