package com.rafihidayat.digitalent.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val username: String,
    val fullName: String,
    val password: String
)