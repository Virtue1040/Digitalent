package com.rafihidayat.digitalent.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class Mahasiswa(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nim: String = "",
    val fullName: String = "",
    val kelas: String = ""
)