package com.example.pokesd.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokesd.data.UserRepository

class LoginViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {

        if (username.isBlank()) {
            _loginResult.value = LoginResult(errorMessage = "Username cannot be empty")
            return
        }

        if (password.isBlank()) {
            _loginResult.value = LoginResult(errorMessage = "Password cannot be empty")
            return
        }

        val isSuccess = repository.login(username, password)

        if (isSuccess) {
            _loginResult.value = LoginResult(success = true)
        } else {
            _loginResult.value = LoginResult(errorMessage = "Invalid username or password")
        }
    }
}
