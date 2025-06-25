package com.rafihidayat.digitalent.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.rafihidayat.digitalent.database.UserDao
import com.rafihidayat.digitalent.model.User
import java.security.MessageDigest

class LoginViewModel(private val dao: UserDao) : ViewModel() {
    private fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.joinToString("") { "%02x".format(it) }
    }

    suspend fun login(username: String, password: String): User? {
        val user = dao.login(username, hashPassword(password))
        return user
    }
}