package com.example.pokesd.data

class UserRepository {

    private val dummyUsername = "admin"
    private val dummyPassword = "1234"

    fun login(username: String, password: String): Boolean {
        return username == dummyUsername && password == dummyPassword
    }
}
