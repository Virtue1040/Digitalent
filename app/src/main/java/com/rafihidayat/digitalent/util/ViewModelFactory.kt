package com.rafihidayat.digitalent.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafihidayat.digitalent.database.ResepDao
import com.rafihidayat.digitalent.ui.screen.DetailViewModel
import com.rafi607062330092.assesment2.screen.MainViewModel

class ViewModelFactory(private val dao: ResepDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}