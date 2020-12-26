package com.cheonajjang.appswing.data.model




data class RecipeList(
    val results: List<Recipe> = arrayListOf(),
    val offset: Int = 0,
    val number: Int = 0,
    val totalResults: Int = 0

)
