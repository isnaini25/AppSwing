package com.cheonajjang.appswing.ui.recipe

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.cheonajjang.appswing.R
import com.cheonajjang.appswing.data.model.Recipe
import com.cheonajjang.appswing.databinding.ItemRecipeBinding
import com.cheonajjang.appswing.ui.base.BaseAdapter

class RecipeAdapter(val context: Context) : BaseAdapter<Recipe>(R.layout.item_recipe){
    override fun onBind(binding: ViewDataBinding?, data: Recipe) {
        val mBinding = binding as ItemRecipeBinding
        Glide.with(context).load(data.image).into(mBinding.itemImage)

    }

    override fun onClick(binding: ViewDataBinding?, data: Recipe) {
        val intent = Intent(context, RecipeActivity::class.java)
        intent.putExtra(RecipeActivity.OPEN_RECIPE, data)
        context.startActivity(intent)


    }
}



