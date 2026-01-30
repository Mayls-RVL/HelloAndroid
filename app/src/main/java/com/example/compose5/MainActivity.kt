package com.example.compose5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.compose5.ui.theme.Compose5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose5Theme {
                // Create your ViewModel
                val viewModel = PostViewModel()

                // Call the Composable
                PostScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun PostScreen(viewModel: PostViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is PostUiState.Loading -> {
            Text("Loading posts...")
        }

        is PostUiState.Success -> {
            val posts = (uiState as PostUiState.Success).posts
            LazyColumn {
                items(posts) { post ->
                    Column {
                        Text(text = post.title)
                        Text(text = post.body)
                    }
                }
            }
        }

        is PostUiState.Error -> {
            Text(text = "Error: ${(uiState as PostUiState.Error).message}")
        }
    }
}
