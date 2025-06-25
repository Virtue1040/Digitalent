package com.rafihidayat.digitalent.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafihidayat.digitalent.database.MahasiswaDao
import com.rafihidayat.digitalent.database.UserDao
import com.rafihidayat.digitalent.ui.viewmodel.FormViewModel
import com.rafihidayat.digitalent.ui.viewmodel.ListViewModel
import com.rafihidayat.digitalent.ui.viewmodel.LoginViewModel
import com.rafihidayat.digitalent.ui.viewmodel.RegisterViewModel

class ViewModelFactory(private val dao: UserDao, private val dao2: MahasiswaDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(dao2) as T
        } else if (modelClass.isAssignableFrom(FormViewModel::class.java)) {
            return FormViewModel(dao2) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}