package com.rafihidayat.digitalent.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Dao
import androidx.room.Delete
import com.rafihidayat.digitalent.model.Mahasiswa
import com.rafihidayat.digitalent.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User): Long

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): User?

    @Query("SELECT NOT EXISTS (SELECT 1 FROM user WHERE username = :username)")
    suspend fun checkUsernameAvailability(username: String): Boolean
}