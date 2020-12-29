package com.cheonajjang.appswing.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheonajjang.appswing.data.model.ActionState
import com.cheonajjang.appswing.data.model.Recipe
import com.cheonajjang.appswing.data.repository.RecipeRepository
import kotlinx.coroutines.launch
import retrofit2.http.Query

class RecipeViewModel : ViewModel() {
    private val repo: RecipeRepository by lazy { RecipeRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Recipe>>()
    val detailResp = MutableLiveData<Recipe>()
    val searchResp = MutableLiveData<List<Recipe>>()

    val query = MutableLiveData("")
    val ids = MutableLiveData("")

    fun listRecipe(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listRecipe()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailRecipe(ids: String? = this.ids.value){
        ids?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailRecipe(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchRecipe(query: String? = this.query.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchRecipe(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}