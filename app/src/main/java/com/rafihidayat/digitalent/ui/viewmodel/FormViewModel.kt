package com.rafihidayat.digitalent.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafihidayat.digitalent.database.MahasiswaDao
import com.rafihidayat.digitalent.database.UserDao
import com.rafihidayat.digitalent.model.Mahasiswa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date

class FormViewModel(private val dao: MahasiswaDao) : ViewModel() {
    fun insert(nim: String, fullName: String, kelas: String) {
        val mahasiswa = Mahasiswa(
            nim = nim,
            fullName = fullName,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(mahasiswa)
        }
    }

    fun update(id: Long, nim: String, fullName: String, kelas: String) {
        val mahasiswa = Mahasiswa(
            id = id,
            nim = nim,
            fullName = fullName,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(mahasiswa)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }

    suspend fun getMahasiswa(id: Long): Mahasiswa? {
        return dao.getMahasiswaById(id)
    }
}