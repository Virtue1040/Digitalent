package com.rafihidayat.digitalent.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.rafihidayat.digitalent.database.UserDao
import com.rafihidayat.digitalent.model.User
import java.security.MessageDigest

class RegisterViewModel(private val dao: UserDao) : ViewModel() {
    private fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.joinToString("") { "%02x".format(it) }
    }

    suspend fun register(username: String, fullName: String, password: String, confirmedPassword: String): User? {
        if (password == confirmedPassword) {
            val check = dao.checkUsernameAvailability(username)

            if (!check) {
                return null
            } else {
                val user = User(
                    username = username,
                    fullName = fullName,
                    password = hashPassword(password)
                )

                return User(
                    id = dao.insert(user),
                    username = username,
                    fullName = fullName,
                    password = hashPassword(password)
                )
            }
        } else {
            return null
        }
    }
}