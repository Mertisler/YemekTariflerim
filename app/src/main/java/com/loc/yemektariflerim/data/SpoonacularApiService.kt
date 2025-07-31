package com.loc.yemektariflerim.data

import com.loc.yemektariflerim.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApiService {
    @GET("recipes/complexSearch")
    suspend fun getRecipes(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String,
        @Query("number") number: Int = 20
    ): RecipeResponse
}