package com.rafihidayat.digitalent.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafihidayat.digitalent.database.UserDao
import com.rafihidayat.digitalent.ui.viewmodel.LoginViewModel

class ViewModelFactory(
    private val dao: UserDao

    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}