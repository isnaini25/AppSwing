package com.cheonajjang.appswing.data.remote

import com.cheonajjang.appswing.data.model.RecipeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {
    @GET("complexSearch?apiKey=722e88c273664058811bccf834b5d6b2")
    fun listRecipe() : Call<RecipeList>

    @GET("complexSearch?apiKey=722e88c273664058811bccf834b5d6b2&")
    fun detailRecipe(@Query("query") query: String) : Call<RecipeList>

    @GET("informationBulk?apiKey=722e88c273664058811bccf834b5d6b2&")
    fun searchRecipe(@Query("ids") query: String) : Call<RecipeList>

}
