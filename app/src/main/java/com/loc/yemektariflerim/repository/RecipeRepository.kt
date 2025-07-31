package com.loc.yemektariflerim.repository

import com.loc.yemektariflerim.RetrofitInstance
import com.loc.yemektariflerim.model.Recipe

class RecipeRepository {
    private val apiKey = "5f321ea5b0ed475e939438c026be4ded"

    suspend fun getRecipes(): List<Recipe> {

        val searchQuery = "pasta"


        return RetrofitInstance.api.getRecipes(
            query = searchQuery,
            apiKey = apiKey,
            number = 20
        ).results
    }
}