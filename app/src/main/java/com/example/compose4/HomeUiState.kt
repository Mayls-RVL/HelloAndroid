package com.example.compose4

import android.os.Message
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.foundation.lazy.items


data class HomeItem(val id: Int,val title: String, val description: String)

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val users: List<User>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}





@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {

        is HomeUiState.Loading -> {
            Text("Loading...")
        }

        is HomeUiState.Success -> {
            val users = (uiState as HomeUiState.Success).users

            LazyColumn {
                items(users) { user ->
                    Column {
                        Text(text = user.name)
                        Text(text = user.email)
                    }
                }
            }
        }

        is HomeUiState.Error -> {
            Text("Error")
        }
    }

}
