package com.loc.yemektariflerim.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loc.yemektariflerim.ui.DetailScreen
import com.loc.yemektariflerim.ui.HomeScreen
import com.loc.yemektariflerim.viewmodel.RecipeViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{recipeId}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}

@Composable
fun NavGraph(navController: NavHostController,viewModel: RecipeViewModel,modifier: Modifier = Modifier) {
    NavHost(navController=navController,
        startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            HomeScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toInt() ?: 0
            DetailScreen(recipeId = recipeId, viewModel = viewModel)
        }
    }
}