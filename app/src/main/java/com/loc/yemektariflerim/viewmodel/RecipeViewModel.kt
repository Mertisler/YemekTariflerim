package com.loc.yemektariflerim.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.yemektariflerim.model.Recipe
import com.loc.yemektariflerim.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val repository = RecipeRepository()

    private val _recipes = mutableStateOf<List<Recipe>>(emptyList())
    val recipes: State<List<Recipe>> = _recipes

    init {
        viewModelScope.launch {
            try {
                _recipes.value = repository.getRecipes()
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error: ${e.message}")
            }
        }
    }
}
