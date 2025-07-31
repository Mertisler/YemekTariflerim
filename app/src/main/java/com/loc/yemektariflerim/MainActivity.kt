package com.loc.yemektariflerim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.loc.yemektariflerim.navigation.NavGraph
import com.loc.yemektariflerim.ui.components.BottomBar
import com.loc.yemektariflerim.ui.theme.YemekTariflerimTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loc.yemektariflerim.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemekTariflerimTheme {
                val navController = rememberNavController()
                val viewModel: RecipeViewModel = viewModel()

                Scaffold(
                    bottomBar = { BottomBar(navController = navController) }
                ) { paddingValues ->
                    NavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}

