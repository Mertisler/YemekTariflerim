package com.loc.yemektariflerim.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.loc.yemektariflerim.viewmodel.RecipeViewModel

@Composable
fun DetailScreen(recipeId: Int, viewModel: RecipeViewModel) {
    val recipe = viewModel.recipes.value.find { it.id == recipeId }

    recipe?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = it.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.title, style = MaterialTheme.typography.headlineSmall)
        }
    } ?: Text("Tarif bulunamadı")
}
