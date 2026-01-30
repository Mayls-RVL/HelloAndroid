package com.example.compose5

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiState: StateFlow<PostUiState> = _uiState

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        RetrofitClient.apiService.getPosts()
            .enqueue(object : Callback<List<Post>> {
                override fun onResponse(
                    call: Call<List<Post>>,
                    response: Response<List<Post>>
                ) {
                    if (response.isSuccessful) {
                        val posts = response.body() ?: emptyList()
                        _uiState.value = PostUiState.Success(posts)
                    } else {
                        _uiState.value = PostUiState.Error("Error code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    _uiState.value = PostUiState.Error(t.message ?: "Unknown Error")
                }
            })
    }
}
