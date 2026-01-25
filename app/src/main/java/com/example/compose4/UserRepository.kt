package com.example.compose4

data class User(val name: String, val email: String)

interface UserRepository {
    fun findUserOrNull(name: String): User?
    fun addUsers(users: List<User>)

    fun getUsers(): List<User>
}

class UserRepositoryImpl : UserRepository {
    private val _users = arrayListOf(
        User("John Doe", "john@email.com"),
        User("Jane Smith", "jane@email.com"),
        User("Alex Brown", "alex@email.com")
    )


    override fun findUserOrNull(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }

    override fun getUsers(): List<User> {
        return _users
    }
}

