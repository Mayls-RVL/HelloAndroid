package com.example.pokesd.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokesd.data.AppDatabase
import com.example.pokesd.data.EncryptionHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase
        .getDatabase(application)
        .userDao()

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

        viewModelScope.launch(Dispatchers.IO) {
            val user = userDao.getUserByUsername(username)

            if (user == null) {
                _loginResult.postValue(
                    LoginResult(errorMessage = "Invalid username or password")
                )
            } else {
                val decryptedPassword =
                    EncryptionHelper.decrypt(user.password)

                if (decryptedPassword == password) {
                    _loginResult.postValue(LoginResult(success = true))
                } else {
                    _loginResult.postValue(
                        LoginResult(errorMessage = "Invalid username or password")
                    )
                }
            }
        }
    }
}
