package com.rafihidayat.digitalent.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Dao
import androidx.room.Delete
import com.rafihidayat.digitalent.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}