package com.cheonajjang.appswing.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheonajjang.appswing.R

class RecipeActivity : AppCompatActivity() {
    companion object{
        const val OPEN_RECIPE = "open_recipe"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
    }
}