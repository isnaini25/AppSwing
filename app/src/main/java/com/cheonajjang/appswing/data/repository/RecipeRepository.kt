package com.cheonajjang.appswing.data.repository

import com.cheonajjang.appswing.data.model.ActionState
import com.cheonajjang.appswing.data.model.Recipe
import com.cheonajjang.appswing.data.remote.RecipeService
import com.cheonajjang.appswing.data.remote.RetrofitApi
import retrofit2.await

class RecipeRepository {
    private val recipeService: RecipeService by lazy { RetrofitApi.recipeService() }

    suspend fun listRecipe() : ActionState<List<Recipe>> {
        return try {
            val list = recipeService.listRecipe().await()
            ActionState(list.results)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailRecipe(ids: String) : ActionState<Recipe> {
        return try {
            val list = recipeService.detailRecipe(ids).await()
            ActionState(list.results.first())
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchRecipe(query: String) : ActionState<List<Recipe>> {
        return try {
            val list = recipeService.searchRecipe(query).await()
            ActionState(list.results)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}